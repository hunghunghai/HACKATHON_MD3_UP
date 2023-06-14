package ra.controller;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SongService;
import ra.service.SingerService;

import java.util.Scanner;

public class SongController {
    private SongService songService;
    private SingerService singerService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public SongController(SongService songService, SingerService singerService) {
        this.songService = songService;
        this.singerService = singerService;
    }

    public void addSong() {
        Song song = new Song();
        song.inputData();

        if (song.getSinger() == null) {
            System.out.println("Không tìm thấy ca sĩ nào. Vui lòng thêm một ca sĩ trước..");
            Singer newSinger = new Singer();  // Tạo một đối tượng Singer mới
            newSinger.inputData();  // Nhập thông tin cho đối tượng Singer mới
            singerService.addSinger(newSinger);  // Truyền đối tượng Singer mới vào phương thức addSinger
            song.setSinger(newSinger);
        }

        songService.addSong(song);
        System.out.println("Thêm bài hát thành công.");
    }

    public void displayAllSongs() {
        System.out.println("Danh sách tất cả bài hát:");
        for (Song song : songService.getAllSongs()) {
            song.displayData();
            System.out.println("------------------------");
        }
    }

    public void updateSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID bài hát muốn cập nhật: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            song.inputData();
            songService.updateSong(song);
            System.out.println("Cập nhật bài hát thành công.");
        } else {
            System.out.println("Không tìm thấy bài hát.");
        }
    }

    public void deleteSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập id bài hát muốn xóa: ");
        String songId = scanner.nextLine();

        Song song = songService.findSongById(songId);
        if (song != null) {
            songService.deleteSong(songId);
            System.out.println("Xóa bài hát thành công.");
        } else {
            System.out.println("Không tìm tháy bài hát.");
        }
    }
}
