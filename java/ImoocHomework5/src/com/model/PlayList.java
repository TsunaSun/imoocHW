package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayList {
	private String playListName;
	private ArrayList<Song> musicList = new ArrayList<Song>();

	// 构造方法
	public PlayList(String playListName, ArrayList<Song> musicList) {
		super();
		this.playListName = playListName;
		this.musicList = musicList;
	}

	public PlayList() {
		super();
	}

	// get、set方法
	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public ArrayList<Song> getMusicList() {
		return musicList;
	}

	public void setMusicList(ArrayList<Song> musicList) {
		this.musicList = musicList;
	}

	/**
	 * 添加歌曲到播放列表方法
	 * 
	 * @param song
	 */
	public void addToPlayList(Song song) {
		this.getMusicList().add(song);
	}

	/**
	 * 显示播放列表中所有歌曲方法
	 */
	public void displayAllSong() {
		if (this.getMusicList().isEmpty()) {
			System.out.println("当前播放列表(" + this.getPlayListName() + ")中还没有歌曲哦");
		}
		// 使用iterator
		else {
			System.out.println("当前播放列表(" + this.getPlayListName() + ")歌曲如下");
			Iterator<Song> it = this.getMusicList().iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}

	/**
	 * 通过id查找歌曲
	 * 
	 * @param 歌曲id
	 * @return 找到的歌，没有歌曲或者没有找到则return null
	 */
	public Song searchSongById(String id) {
		// 如果没有歌曲return null;
		Song song;
		for (int i = 0; i < this.getMusicList().size(); i++) {
			if (this.getMusicList().get(i).getId().equals(id)) {
				song = this.getMusicList().get(i);
				return song;
			}
		}
		return null;

	}

	/**
	 * 通过名称查找歌曲
	 * 
	 * @param name
	 * @return 找到的歌
	 */
	public Song searchSongByName(String name) {
		Song song;
		for (int i = 0; i < this.getMusicList().size(); i++) {
			if (this.getMusicList().get(i).getId().equals(name)) {
				song = this.getMusicList().get(i);
				return song;
			}
		}
		return null;
	}

	// 修改歌曲
	public void updateSong(String id, Song song) {
		this.deleteSong(id);
		this.addToPlayList(song);
	}

	// 从播放列表删除歌曲
	public void deleteSong(String id) {
		this.getMusicList().remove(this.searchSongById(id));
	}

	// 导出歌单
	public void exportPlayList() {
		File file = new File(this.getPlayListName() + "的歌单.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < this.getMusicList().size(); i++) {
				oos.writeObject(this.getMusicList().get(i));
			}
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "播放列表信息 [播放列表名称=" + playListName + ", 播放列表=" + musicList + "]";
	}
	
	
}
