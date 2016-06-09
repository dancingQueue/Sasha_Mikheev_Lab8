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

    public void serialize(Catalogue catalogue) {
        EntityCatalogue entityCatalogue = CatalogueConverter.convertToEntityCatalogue(catalogue);
        String entityCatalogueName = entityCatalogue.getEntityCatalogueName();
        String outputFileName = entityCatalogueName + ".ser";
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(outputFileName))) {
            outputStream.writeObject(entityCatalogue);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Catalogue deserialize(String catalogueName) {
        EntityCatalogue resultEntityCatalogue = null;
        String inputFileName = catalogueName + ".ser";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFileName))) {

            resultEntityCatalogue = (EntityCatalogue) inputStream.readObject();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        return CatalogueConverter.convertToCatalogue(resultEntityCatalogue);
    }

}
