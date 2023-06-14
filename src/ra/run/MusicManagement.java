package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class MusicManagement {
    private SingerController singerController;
    private SongController songController;

    public MusicManagement() {
        SingerService singerService = new SingerService();
        SongService songService = new SongService();

        singerController = new SingerController(singerService);
        songController = new SongController(songService);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Quản lý Âm nhạc =====");
            System.out.println("1. Thêm Ca sĩ");
            System.out.println("2. Hiển thị Tất cả Ca sĩ");
            System.out.println("3. Cập nhật Ca sĩ");
            System.out.println("4. Xóa Ca sĩ");
            System.out.println("5. Thêm Bài hát");
            System.out.println("6. Hiển thị Tất cả Bài hát");
            System.out.println("7. Cập nhật Bài hát");
            System.out.println("8. Xóa Bài hát");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    singerController.addSinger();
                    break;
                case 2:
                    singerController.displayAllSingers();
                    break;
                case 3:
                    singerController.updateSinger();
                    break;
                case 4:
                    singerController.deleteSinger();
                    break;
                case 5:
                    songController.addSong();
                    break;
                case 6:
                    songController.displayAllSongs();
                    break;
                case 7:
                    songController.updateSong();
                    break;
                case 8:
                    songController.deleteSong();
                    break;
                case 0:
                    System.out.println("Thoát...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }

    public static void main(String[] args) {
        MusicManagement musicManagement = new MusicManagement();
        musicManagement.start();
    }
}
