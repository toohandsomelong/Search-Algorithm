package MusicApp;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		Music music1 = new Music("Midnight Sky", "Luna Rivers");
		Music music2 = new Music("Sky of Fire", "Ava Night");
		Music music3 = new Music("Dream Walker", "Jayden Storm");
		Music music4 = new Music("Neon Dreams", "Kai Voltage");
		Music music5 = new Music("Moonlight Dance", "Zoe Wilder");
		Music music6 = new Music("Crimson Moon", "Ezra Vale");
		Music music7 = new Music("Skyfall Echo", "Nova Lynn");
		Music music8 = new Music("Shattered Dream", "Leo Grey");
		Music music9 = new Music("Blue Horizon", "Isla Skye");
		Music music10 = new Music("Golden Moon", "Milo Ash");
		Music music11 = new Music("Sky of Water", "Ava Night");

		DigitalMusic digi1 = new DigitalMusic(music1, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 3);
		DigitalMusic digi2 = new DigitalMusic(music2, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 1);
		DigitalMusic digi3 = new DigitalMusic(music3, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 3);
		DigitalMusic digi4 = new DigitalMusic(music4, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 123);
		DigitalMusic digi5 = new DigitalMusic(music5, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 355);
		DigitalMusic digi6 = new DigitalMusic(music6, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 113);
		DigitalMusic digi7 = new DigitalMusic(music7, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 1);
		DigitalMusic digi8 = new DigitalMusic(music8, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 31);
		DigitalMusic digi9 = new DigitalMusic(music9, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 3);
		DigitalMusic digi10 = new DigitalMusic(music10, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 37);
		DigitalMusic digi11 = new DigitalMusic(music11, "https://www.youtube.com/watch?v=tnAoq3_6f5M", 23);
		

		music2.addTag("upbeat");
		music11.addTag("upbeat");
		music11.addTag("funny");
		MusicLibary lib = new MusicLibary();

		lib.addMusic(digi1);
		lib.addMusic(digi2);
		lib.addMusic(digi3);
		lib.addMusic(digi4);
		lib.addMusic(digi5);
		lib.addMusic(digi6);
		lib.addMusic(digi7);
		lib.addMusic(digi8);
		lib.addMusic(digi9);
		lib.addMusic(digi10);
		lib.addMusic(digi11);

		//searching song name "sky of" with tag upbeat and without tag funny
		System.out.println(lib.searchByName("sky of +upbeat -funny"));
		//searching song name "sky of" with tag upbeat and without tag funny
		System.out.println(lib.searchByAuthor("ava +upbeat -funny"));

		List<DigitalMusic> libMusics = lib.musics;
		System.out.println();
		System.out.println("-------------Not sorted------------");
		System.out.println(libMusics);
		System.out.println();
		System.out.println("-----------sortByName desc");
		System.out.println(lib.sortByName(libMusics, true));
		System.out.println();
		System.out.println("-------------sortByName-------------");
		System.out.println(lib.sortByName(libMusics, false));
		System.out.println();
		System.out.println("-----------sortByView desc----------");
		System.out.println(lib.sortByAuthor(libMusics, true));
		System.out.println();
		System.out.println("-------------sortByView-------------");
		System.out.println(lib.sortByView(libMusics, false));
		System.out.println();
		System.out.println("-----------sortByView desc----------");
		System.out.println(lib.sortByView(libMusics, true));
		System.out.println();
		System.out.println("-----------sortByView-------------");
		System.out.println(lib.sortByActor(libMusics, false));
		System.out.println();
		System.out.println("-----------sortByView desc----------");
		System.out.println(lib.sortByView(libMusics, true));
		System.out.println();
		System.out.println("-------------sortByView-------------");
		System.out.println(lib.sortByView(libMusics, false));
		System.out.println();
		System.out.println("TOP 10 view");
		System.out.println(lib.getTop10Views());
	}
}
