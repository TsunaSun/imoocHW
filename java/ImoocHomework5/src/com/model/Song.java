package com.model;

import java.io.Serializable;

public class Song implements Serializable{
	// 歌曲属性：ID、歌曲名、演唱者
	private String id;
	private String name;
	private String singer;

	// get、set方法
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	// 构造方法
	public Song() {
		super();
		
	}

	public Song(String id, String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
	}

	// hashCode和equals方法

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj.getClass() == Song.class) {
			Song song = (Song) (obj);
			return song.getId() == this.getId() && song.getName() == this.getName()
					&& song.getSinger() == this.getSinger();
		}
		return false;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "歌曲信息： [歌曲id=" + id + ", 歌曲名=" + name + ", 演唱者=" + singer + "]";
	}
	
	
	
}
