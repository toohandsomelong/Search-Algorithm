package MusicApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MusicLibary
{
	protected List<DigitalMusic> musics  = new ArrayList<DigitalMusic>();
	protected List<Album> albums = new ArrayList<Album>();

	public MusicLibary(){}

	public MusicLibary(List<DigitalMusic> musics, List<Album> albums)
	{
		this.musics = musics;
		this.albums = albums;
	}

	public void addMusic(DigitalMusic music)
	{
		musics.add(music);
	}

	public void addAlbum(Album album)
	{
		albums.add(album);
	}

	public List<DigitalMusic> searchByName(String input)
	{
		List<DigitalMusic> l = new ArrayList<>();

		//split("\\s+") splits on any number of spaces.
		//trim()	Removes whitespace at start/end only
		String[] tokens = input.trim().split("\\s+");
		List<String> tags = new ArrayList<>();
		List<String> tagsToRemove = new ArrayList<>();

		// collect name parts until hit a token starting with + or -
		int i = 0;
		StringBuilder nameBuilder = new StringBuilder();
		while (i < tokens.length && !tokens[i].startsWith("+") && !tokens[i].startsWith("-")) {
			if (nameBuilder.length() > 0) nameBuilder.append(" ");
			nameBuilder.append(tokens[i]);
			i++;
		}
		String name = nameBuilder.toString();

		// collect all + and – values
		for (; i < tokens.length; i++)
		{
			String token = tokens[i];
			if (token.startsWith("+") && token.length() > 1)
				tags.add(token.substring(1));
			else if (token.startsWith("-") && token.length() > 1)
				tagsToRemove.add(token.substring(1));
		}
		
		List<String> words = Arrays.asList(name.split("\\s+"));

		while (true)
		{
			//get list that contain any of these word
			for (String word : words)
			{
				addMusicContainingWordTitle(l, word);
			}

			if (words.size() <= 1)
				break;

			words = combineWords(words);
		}

		//sort by tag
		addMusicContainingTags(l, tags);
		removeMusicContainingTags(l, tagsToRemove);

		Collections.reverse(l);
		return l;
	}

	public List<DigitalMusic> searchByAuthor(String input)
	{
		List<DigitalMusic> l = new ArrayList<>();

		//split("\\s+") splits on any number of spaces.
		//trim()	Removes whitespace at start/end only
		String[] tokens = input.trim().split("\\s+");
		List<String> tags = new ArrayList<>();
		List<String> tagsToRemove = new ArrayList<>();

		// collect name parts until hit a token starting with + or -
		int i = 0;
		StringBuilder nameBuilder = new StringBuilder();
		while (i < tokens.length && !tokens[i].startsWith("+") && !tokens[i].startsWith("-"))
		{
			if (nameBuilder.length() > 0)
				nameBuilder.append(" ");
			nameBuilder.append(tokens[i]);
			i++;
		}
		String name = nameBuilder.toString();

		// collect all + and – values
		for (; i < tokens.length; i++)
		{
			String token = tokens[i];
			if (token.startsWith("+") && token.length() > 1)
				tags.add(token.substring(1));
			else if (token.startsWith("-") && token.length() > 1)
				tagsToRemove.add(token.substring(1));
		}

		List<String> words = Arrays.asList(name.split("\\s+"));

		while (true)
		{
			//get list that contain any of these word
			for (String word : words)
			{
				addMusicContainingWordAuthor(l, word);
			}

			if (words.size() <= 1)
				break;

			words = combineWords(words);
		}

		//sort by tag
		addMusicContainingTags(l, tags);
		removeMusicContainingTags(l, tagsToRemove);

		Collections.reverse(l);
		return l;
	}

	public List<DigitalMusic> sortByName(List<DigitalMusic> list, boolean isDesc)
	{
		List<DigitalMusic> temp = new ArrayList<>(list);
		temp.sort(Comparator.comparing(m -> m.title));

		if (isDesc)
			Collections.reverse(temp);

		return temp;
	}

	public List<DigitalMusic> sortByAuthor(List<DigitalMusic> list, boolean isDesc)
	{
		List<DigitalMusic> temp = new ArrayList<>(list);
		temp.sort(Comparator.comparing(m -> m.author));

		if (isDesc)
			Collections.reverse(temp);

		return temp;
	}

	public List<DigitalMusic> sortByActor(List<DigitalMusic> list, boolean isDesc)
	{
		List<DigitalMusic> temp = new ArrayList<>(list);
		temp.sort(Comparator.comparing(m -> m.actor));

		if (isDesc)
			Collections.reverse(temp);

		return temp;
	}

	public List<DigitalMusic> sortByView(List<DigitalMusic> list, boolean isDesc)
	{
		List<DigitalMusic> temp = new ArrayList<>(list);
		temp.sort(Comparator.comparing(m -> m.views));

		if (!isDesc)
			Collections.reverse(temp);

		return temp;
	}

	public List<DigitalMusic> getTop10Views()
	{
		return new ArrayList<>( sortByView(musics, false) );

	}

	private void addMusicContainingWordTitle(List<DigitalMusic> l, String word)
	{
		for (DigitalMusic m : musics)
		{
			String mName = m.title.toLowerCase();
			if (!mName.contains(word))
				continue;

			//remove so it place to last of the list then i could reverse it to show the most related name on top
			l.remove(m);
			l.add(m);
		}
	}

	private void addMusicContainingWordAuthor(List<DigitalMusic> l, String word)
	{
		for (DigitalMusic m : musics)
		{
			String mName = m.author.toLowerCase();
			if (!mName.contains(word))
				continue;

			//remove so it place to last of the list then i could reverse it to show the most related name on top
			l.remove(m);
			l.add(m);
		}
	}

	private void addMusicContainingTags(List<DigitalMusic> l, List<String> tags)
	{
		if(tags.size() < 1)
			return;

		List<DigitalMusic> temp = new ArrayList<>(l);
		for (DigitalMusic m : temp)
		{
			if (!isMatchingTag(tags, m.tags))
			{
				l.remove(m);
				continue;
			}

			if (l.contains(m))
				continue;

			//remove so it place to last of the list then i could reverse it to show the most related name on top
			l.remove(m);
			l.add(m);
		}
	}

	private void removeMusicContainingTags(List<DigitalMusic> l, List<String> tags)
	{
		if(tags.size() < 1)
			return;

		List<DigitalMusic> temp = new ArrayList<>(l);
		for (DigitalMusic m : temp)
		{
			if (!isMatchingTag(tags, m.tags))
				continue;

			//remove so it place to last of the list then i could reverse it to show the most related name on top
			l.remove(m);
		}
	}

	private boolean isMatchingTag(List<String> tags, List<String> mTags)
	{
		boolean hasMatchingTag = false;
		for (String tag : tags)
		{
			if (!mTags.contains(tag))
			{
				hasMatchingTag = false;
				break;
			}

			hasMatchingTag = true;
		}
		return hasMatchingTag;
	}
	
	private List<String> combineWords(List<String> words)
	{
		List<String> words2 = new ArrayList<String>();
		for (int i = 0; i < words.size() - 1; i++)
		{
			String combined = words.get(i) + " " + words.get(i + 1);
			words2.add(combined);
		}

		// If words1.size is odd, add the last word to words2
		if (words.size() % 2 != 0)
		{
			words2.add(words.get(words.size() - 1));
		}

		return words2;
	}
}
