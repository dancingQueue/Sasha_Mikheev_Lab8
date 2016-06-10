package serializators;

import converters.CatalogueConverter;
import entities.EntityCatalogue;
import interfaces.Serializator;
import model.Catalogue;

import java.io.*;

/**
 * Created by alexandermiheev on 09.06.16.
 */
public class CatalogByteSerializator implements Serializator<Catalogue> {
    private static final String FILE_FORMAT = ".ser";

    public void serialize(Catalogue catalogue) {
        EntityCatalogue entityCatalogue = CatalogueConverter.convertToEntityCatalogue(catalogue);
        String entityCatalogueName = entityCatalogue.getEntityCatalogueName();
        String outputFileName = entityCatalogueName + FILE_FORMAT;

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(outputFileName))) {
            outputStream.writeObject(entityCatalogue);
        } catch (IOException e) {
            throw new RuntimeException("serialize() IOException" + e.getMessage());
        }
    }

    public Catalogue deserialize(String catalogueName) {
        EntityCatalogue entityCatalogue = null;
        String inputFileName = catalogueName + FILE_FORMAT;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFileName))) {

            entityCatalogue = (EntityCatalogue) inputStream.readObject();

        } catch (IOException e) {
            throw new RuntimeException("serialize() IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("serialize() ClassNotFoundException" + e.getMessage());
        }

        Catalogue resultCatalogue = CatalogueConverter.convertToCatalogue(entityCatalogue);
        return resultCatalogue;
    }

}
