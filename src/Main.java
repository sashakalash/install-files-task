import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String GAMES_DIR_PATH = "/Users/admin/Games";

    private static final String SRC_DIR_PATH = "/src";
    private static final String RES_DIR_PATH = "/res";
    private static final String SAVEGAMES_DIR_PATH = "/savegames";
    private static final String TEMP_DIR_PATH = "/temp";

    private static final String SRC_MAIN_DIR_PATH = "/main";
    private static final String SRC_TEST_DIR_PATH = "/test";

    private static final String DRAWABLES_DIR_PATH = "/drawables";
    private static final String VECTORS_DIR_PATH = "/vectors";
    private static final String ICONS_DIR_PATH = "/icons";

    private static final String MAIN_FILE_NAME = "Main.java";
    private static final String UTILS_FILE_NAME = "Utils.java";
    private static final String TEMP_FILE_NAME = "temp.txt";

    public static StringBuilder report = new StringBuilder();


    public static void main(String[] args) {
        createDirectories();
        createFiles();
        createReport();
    }

    public static void createFiles() {
        File main = new File(GAMES_DIR_PATH + SRC_DIR_PATH + SRC_MAIN_DIR_PATH, MAIN_FILE_NAME);
        File utils = new File(GAMES_DIR_PATH + SRC_DIR_PATH + SRC_MAIN_DIR_PATH, UTILS_FILE_NAME);
        File temp = new File(GAMES_DIR_PATH + TEMP_DIR_PATH, TEMP_FILE_NAME);
        createFile(main);
        createFile(utils);
        createFile(temp);
    }

    public static void createDirectories() {
        createDir(GAMES_DIR_PATH + SRC_DIR_PATH + SRC_MAIN_DIR_PATH);
        createDir(GAMES_DIR_PATH + SRC_DIR_PATH + SRC_TEST_DIR_PATH);
        createDir(GAMES_DIR_PATH + RES_DIR_PATH + DRAWABLES_DIR_PATH);
        createDir(GAMES_DIR_PATH + RES_DIR_PATH + VECTORS_DIR_PATH);
        createDir(GAMES_DIR_PATH + RES_DIR_PATH + ICONS_DIR_PATH);
        createDir(GAMES_DIR_PATH + SAVEGAMES_DIR_PATH);
        createDir(GAMES_DIR_PATH + TEMP_DIR_PATH);
    }

    public static void createDir(String path) {
        File dir = new File(path);
        try {
            if (!dir.exists()) {
                dir.mkdirs();
                report.append("Директория '" + path + "' успешно создана\n");
            } else {
                report.append("Ошибка создания директории '" + path + "'\n");
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                report.append("Файл '" + file.getName() + "' был успешно создан\n");
            } else {
                report.append("Ошибка создания файла '" + file.getName() + "'\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createReport() {
        try (FileWriter writer = new FileWriter(GAMES_DIR_PATH + TEMP_DIR_PATH + "/" + TEMP_FILE_NAME, false)) {
            writer.write(report.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}