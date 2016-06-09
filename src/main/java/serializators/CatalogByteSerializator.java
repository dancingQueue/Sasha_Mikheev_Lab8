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

    public void serialization(Catalogue catalogue) {
        EntityCatalogue entityCatalogue = CatalogueConverter.convertToEntityCatalogue(catalogue);
        String entityCatalogueName = entityCatalogue.getEntityCatalogueName();
        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(new FileOutputStream(entityCatalogueName + ".ser"))){
            outputStream.writeObject(entityCatalogue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Catalogue deserialization(String fileName) {
        EntityCatalogue resultEntityCatalogue = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {

            resultEntityCatalogue = (EntityCatalogue) inputStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return CatalogueConverter.convertToCatalogue(resultEntityCatalogue);
    }

}
