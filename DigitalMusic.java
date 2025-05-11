package MusicApp;

import java.util.List;

public class DigitalMusic extends Music
{
	private String description = "";
	protected String actor = "";
	protected String link = "";
	protected int views = -1;
	
	public DigitalMusic(String title, String lyrics, String author, List<String> tags, String description, String actor,
			String link, int views)
	{
		super(title, lyrics, author, tags);
		this.description = description;
		this.actor = actor;
		this.link = link;
		this.views = views;
	}
	
	public DigitalMusic(Music music, String description, String actor, String link, int views)
	{
		super(music.title, music.lyrics, music.author, music.tags);
		this.description = description;
		this.actor = actor;
		this.link = link;
		this.views = views;
	}
	
	public DigitalMusic(Music music, String link, int views)
	{
		super(music.title, music.lyrics, music.author, music.tags);
		this.link = link;
		this.views = views;
	}

	public void updateView(int n)
	{
		views = n;
	}

	@Override
	public String toString()
	{
		return super.toString() + " - " + link + " - " + views;
	}

	@Override
	public String longToString() {
		return "DigitalMusic {\n" +
			   super.toString()   +
			   "  Description : " + (description != null && description.length() > 50 ? description.substring(0, 47) + "..." : description) + "\n" +
			   "  Actor       : " + actor + "\n" +
			   "  Link        : " + link + "\n" +
			   "  Views       : " + views + "\n" +
			   "}";
	}
}
