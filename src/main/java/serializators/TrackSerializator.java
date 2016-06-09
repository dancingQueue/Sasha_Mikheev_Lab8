package serializators;

import converters.TrackConverter;
import entities.EntityTrack;
import interfaces.Serializator;
import model.Track;
import parsers.StringParser;

import java.io.*;

/**
 * Created by alexandermiheev on 06.06.16.
 */
public class TrackSerializator implements Serializator<Track> {

    public void serialization(Track track) {
        try {
            EntityTrack entityTrack = TrackConverter.convertToEntityTrack(track);
            PrintStream outStream = new PrintStream(entityTrack.getEntityTrackName() + ".txt");
            WriteInStream.writeTrack(entityTrack, outStream);
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Track deserialization(String fileName) throws RuntimeException{
        EntityTrack resultEntityTrack = new EntityTrack();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName));)
        {
            String currentIdentificator = inputStream.readLine();
            if (!currentIdentificator.equals("Track")) {
                throw new RuntimeException("Invalid track identificator");
            }
            String trackDescription = inputStream.readLine();
            resultEntityTrack = StringParser.parseEntityTrack(trackDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TrackConverter.convertToTrack(resultEntityTrack);
    }
}
