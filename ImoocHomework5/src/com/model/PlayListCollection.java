package com.model;

import java.util.HashMap;
import java.util.Map;

public class PlayListCollection {

	private Map<String, PlayList> playListMap = new HashMap<String,PlayList>();

	// 构造方法
	public PlayListCollection(Map<String, PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}

	public PlayListCollection() {
		super();
	}

	// get、set方法
	public Map<String, PlayList> getPlayListMap() {
		return playListMap;
	}

	public void setPlayListMap(Map<String, PlayList> playListMap) {
		this.playListMap = playListMap;
	}

	// 添加播放列表
	public void addPlayList(PlayList playList) {
		this.getPlayListMap().put(playList.getPlayListName(), playList);
	}
	
	/**
	 * 根据名称删除播放列表
	 * @param playListName
	 */
	public void deletePlayList(String playListName) {
		this.getPlayListMap().remove(playListName);
	}

	// 通过名字查询
	public PlayList searchPlayListByName(String playListName) {
		if (this.getPlayListMap().containsKey(playListName)) {
			return this.getPlayListMap().get(playListName);
		}
		return null;
	}

	// 显示所有播放列表
	public void displayPlayListName() {
		// 因为必定有主播放列表，所以不可能为空
		for (String s : this.getPlayListMap().keySet()) {
			System.out.println(s);
		}
		
	}
}
