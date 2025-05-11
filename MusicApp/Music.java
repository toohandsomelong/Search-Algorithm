package MusicApp;

import java.util.ArrayList;
import java.util.List;

public class Music
{
	protected String title = "";
	protected String lyrics = "";
	protected String author = "";
	protected List<String> tags = new ArrayList<String>();

	public Music(String title, String lyrics, String author, List<String> tags)
	{
		this.title = title;
		this.lyrics = lyrics;
		this.author = author;
		this.tags = tags;
	}

	public Music(String title, String lyrics, String author)
	{
		this.title = title;
		this.lyrics = lyrics;
		this.author = author;
	}

	public Music(String title, String author)
	{
		this.title = title;
		this.author = author;
	}

	public void addTag(String tag)
	{
		if (tags.contains(tag))
			return;

		tags.add(tag);
	}
	
	@Override
	public String toString()
	{
		return "\n" + title + " - " + author;
	}

	public String longToString()
	{
		return "Music {\n" +
			"  Name    : " + title + "\n" +
			"  Author  : " + author + "\n" +
			"  Lyrics  : " + (lyrics != null && lyrics.length() > 50 ? lyrics.substring(0, 47) + "..." : lyrics) + "\n" +
			"  Tags    : " + String.join(", ", tags) + "\n" +
			"}";
	}
}
