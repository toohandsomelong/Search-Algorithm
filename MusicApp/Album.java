package MusicApp;

import java.util.ArrayList;
import java.util.List;

public class Album
{
	private String name;
	private String releaseDate;
	private String publisher;
	private List<Music> musics  = new ArrayList<Music>();

	public Album(String name, String releaseDate, String publisher)
	{
		this.name = name;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
	}

	public Album(String name, String releaseDate, String publisher, List<Music> musics)
	{
		this.name = name;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.musics = musics;
	}

	public void addMusic(Music music)
	{
		musics.add(music);
	}
}
