package ee.ellytr.autoclick.log;

import ee.ellytr.autoclick.EllyCheat;

import java.io.*;
import java.util.logging.Level;

public class UserLog {

    private File file;
    private String username;

    public UserLog(String username, String logName) throws IOException {
        this.username = username;
        createFolderDatabase();
        file = new File(EllyCheat.getInstance().getDataFolder(), "players/" + username + "/" + logName + ".log");
        if (!file.exists()) file.createNewFile();
    }

    private void createFolderDatabase() {
        File dataFolder = EllyCheat.getInstance().getDataFolder();
        if (!dataFolder.exists()) dataFolder.mkdir();
        File players = new File(dataFolder, "players");
        if (!players.exists()) players.mkdir();
        File playerFolder = new File(players, username);
        if (!playerFolder.exists()) playerFolder.mkdir();
    }

    public void log(String text) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.println(text);
            writer.close();
        } catch (IOException e) {
            EllyCheat.getInstance().getLogger().log(Level.WARNING, "Could not log text '" + text + "' to file '" + username + ".log'");
        }
    }

}
