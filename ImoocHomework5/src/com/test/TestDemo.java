package com.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.model.PlayList;
import com.model.PlayListCollection;
import com.model.Song;

public class TestDemo {
	/**
	 * 主菜单
	 * 
	 * @param
	 */
	public static void infoMain() {
		System.out.println("*******************************************");
		System.out.println("			    	***主菜单***");
		System.out.println("			    	1--播放列表管理");
		System.out.println("			    	2--播放器管理");
		System.out.println("			    	0--退出");
		System.out.println("*******************************************");
		System.out.println("请输入对应数字进行操作：");
	}

	/**
	 * 播放列表管理
	 */
	public static void infoPlayList() {
		System.out.println("*******************************************");
		System.out.println("			    	***播放列表管理***");
		System.out.println("			    	1--将歌曲添加到主播放列表");
		System.out.println("			    	2--将歌曲添加到普通播放列表");
		System.out.println("			    	3--通过歌曲id查询播放列表中的歌曲");
		System.out.println("			    	4--通过歌曲名查询播放列表中的歌曲");
		System.out.println("			    	5--修改播放列表中的歌曲");
		System.out.println("			    	6--删除播放列表中的歌曲");
		System.out.println("			    	7--显示播放列表中的所有歌曲");
		System.out.println("			    	8--导出歌单");
		System.out.println("			    	9--返回上一级菜单");
		System.out.println("*******************************************");
		System.out.println("请输入对应数字来对播放列表进行操作：");
	}

	/**
	 * 播放器管理
	 */
	public static void infoPlayListCollection() {
		System.out.println("*******************************************");
		System.out.println("			    	***播放器管理***");
		System.out.println("			    	1--向播放器添加播放列表");
		System.out.println("			    	2--从播放器删除播放列表");
		System.out.println("			    	3--通过名字查询播放列表名称");
		System.out.println("			    	4--显示所有播放列表名称");
		System.out.println("			    	9--返回上一级菜单");
		System.out.println("*******************************************");
		System.out.println("请输入对应数字来对播放器进行操作：");
	}

	public static void main(String[] args) {
		System.out.println("欢迎使用本播放器！");
		// 输入
		Scanner input = new Scanner(System.in);
		int info; // 对菜单进行操作的数字
		boolean flagMain = false;// 跳出主菜单判断
		PlayListCollection plc = new PlayListCollection();// 播放器
		PlayList mainPlayList = new PlayList();// 主播放列表
		mainPlayList.setPlayListName("主播放列表");
		plc.addPlayList(mainPlayList);// 先添加主播放列表
		// 主菜单操作
		while (true) {
			try {
				infoMain();
				info = input.nextInt();
				if (info < 0 || info > 2) {
					System.out.println("请输入正确的数字进行操作");
					continue;
				} else {
					switch (info) {
					// 进入播放列表管理
					case 1: {
						boolean flagPlayList = false;// 跳出播放列表判断
						// 播放列表循环
						while (true) {
							try {
								infoPlayList();
								info = input.nextInt();
								if (info < 1 || info > 9) {
									System.out.println("请输入正确的数字进行操作");
									continue;
								} else {
									switch (info) {
									// 1：将歌曲添加到主播放列表
									case 1: {
										System.out.println("将歌曲添加到主播放列表");
										System.out.println("请输入要添加的歌曲数量");
										int cnt; // cnt为歌曲数量统计
										String id;
										String name;
										String singer;
										boolean flag;
										try {
											cnt = input.nextInt();
											// 输入小于等于0则退出添加歌曲
											if (cnt <= 0) {
												System.out.println("您输入的数目小于等于0，退出此次添加歌曲。");
											} else {
												for (int i = 1; i <= cnt; i++) {
													System.out.println("输入第" + i + "首歌");
													// 放入循环里，如果歌曲id存在，则重新输入
													while (true) {
														flag = false; // flag判断id是否存在 true：存在
														System.out.println("请输入歌曲id：");
														id = input.next();
														for (int j = 0; j < plc.searchPlayListByName("主播放列表")
																.getMusicList().size(); j++) {
															if (plc.searchPlayListByName("主播放列表").getMusicList().get(j)
																	.getId().equals(id)) {
																System.out.println("该id已经存在，请重新输入");
																flag = true;
																break;
															}
														}
														if (flag) {
															continue;
														} else {
															break;
														}
													}
													// 放入循环里，如果歌曲名和演唱者都一样存在，则重新输入
													while (true) {
														flag = false;
														System.out.println("请输入歌曲名：");
														name = input.next();
														System.out.println("请输入演唱者：");
														singer = input.next();
														for (int j = 0; j < plc.searchPlayListByName("主播放列表")
																.getMusicList().size(); j++) {
															if (plc.searchPlayListByName("主播放列表").getMusicList().get(j)
																	.getName().equals(name)
																	&& plc.searchPlayListByName("主播放列表").getMusicList()
																			.get(j).getSinger().equals(singer)) {
																System.out.println("该歌曲名和演唱者已和其他歌相同，请重新输入");
																flag = true;
																break;
															}
														}
														if (flag) {
															continue;
														} else {
															break;
														}
													}
													plc.searchPlayListByName("主播放列表")
															.addToPlayList(new Song(id, name, singer));
												}
											}
											break;
											// 防止输入不为整数
										} catch (InputMismatchException e) {
											// TODO Auto-generated catch block
											System.out.println("请输入整数！");
											input.next();
											break;
										}
									}
									// 将歌曲添加到普通播放列表
									case 2: {
										System.out.println("将歌曲添加到普通播放列表");
										System.out.println("请输入要添加的歌曲数量");
										int cnt; // cnt为歌曲数量统计
										String id;
										String name;
										String singer;
										String playListname;
										System.out.println("请输入要添加歌曲的播放列表");
										playListname = input.next();
										if (plc.searchPlayListByName(playListname) == null) {
											System.out.println("您输入的播放列表不存在！请先将播放列表添加到播放器中！");
										} else {
											boolean flag;
											try {
												cnt = input.nextInt();
												// 输入小于等于0则退出添加歌曲
												if (cnt <= 0) {
													System.out.println("您输入的数目小于等于0，退出此次添加歌曲。");
													return;
												} else {
													for (int i = 1; i <= cnt; i++) {
														System.out.println("输入第" + i + "首歌");
														// 放入循环里，如果歌曲id存在，则重新输入
														while (true) {
															flag = false; // flag判断id是否存在 true：存在
															System.out.println("请输入歌曲id：");
															id = input.next();
															for (int j = 0; j < plc.searchPlayListByName(playListname)
																	.getMusicList().size(); j++) {
																if (plc.searchPlayListByName(playListname)
																		.getMusicList().get(j).getId().equals(id)) {
																	System.out.println("该id已经存在，请重新输入");
																	flag = true;
																	break;
																}
															}
															if (flag) {
																continue;
															} else {
																break;
															}
														}
														// 放入循环里，如果歌曲名和演唱者都一样，则重新输入
														while (true) {
															flag = false;
															System.out.println("请输入歌曲名：");
															name = input.next();
															System.out.println("请输入演唱者：");
															singer = input.next();
															for (int j = 0; j < plc.searchPlayListByName(playListname)
																	.getMusicList().size(); j++) {
																if (plc.searchPlayListByName(playListname)
																		.getMusicList().get(j).getName().equals(name)
																		&& plc.searchPlayListByName(playListname)
																				.getMusicList().get(j).getSinger()
																				.equals(singer)) {
																	System.out.println("该歌曲名和演唱者已和其他歌相同，请重新输入");
																	flag = true;
																	break;
																}
															}
															if (flag) {
																continue;
															} else {
																break;
															}
														}
														plc.searchPlayListByName(playListname)
																.addToPlayList(new Song(id, name, singer));
														// 如果主播放列表里没有这首歌，则也添加入主播放列表
														if (plc.searchPlayListByName("主播放列表")
																.searchSongById(id) == null) {
															System.out.println("这首歌在主播放列表中不存在，已为你添加入主播放列表");
															plc.searchPlayListByName("主播放列表")
																	.addToPlayList(new Song(id, name, singer));
														}
													}
												}
												break;
												// 防止输入不为整数
											} catch (InputMismatchException e) {
												// TODO Auto-generated catch block
												System.out.println("请输入整数！");
												input.next();
												break;
											}
										}
									}

									// 通过歌曲id查询播放列表中的歌曲
									case 3: {
										System.out.println("请输入要查询的播放列表");
										String playListName;
										playListName = input.next();
										if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在！");
										} else {
											String id;
											System.out.println("请输入要查询的歌曲id");
											id = input.next();
											if (plc.searchPlayListByName(playListName).searchSongById(id) == null) {
												System.out.println("该歌曲在播放列表" + playListName + "中不存在");
											} else {
												System.out.println("该歌曲信息为：");
												System.out.println(
														plc.searchPlayListByName(playListName).searchSongById(id));
											}
										}
										break;
									}

									// 通过歌曲名称查询播放列表中的歌曲
									case 4: {
										System.out.println("请输入要查询的播放列表");
										String playListName;
										playListName = input.next();
										if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在！");
										} else {
											String songName;
											System.out.println("请输入要查询的歌曲名称");
											songName = input.next();
											if (plc.searchPlayListByName(playListName)
													.searchSongById(songName) == null) {
												System.out.println("该歌曲在播放列表" + playListName + "中不存在");
											} else {
												System.out.println("该歌曲信息为：");
												System.out.println(plc.searchPlayListByName(playListName)
														.searchSongById(songName));

											}
										}
										break;
									}

									// 修改播放列表中的歌曲
									case 5: {
										System.out.println("修改播放列表中的歌曲");
										System.out.println("请输入要修改的歌曲id");
										String id = input.next();
										if (plc.searchPlayListByName("主播放列表").searchSongById(id) == null) {
											System.out.println("该歌曲不存在！");
										} else {
											String name;
											String singer;
											System.out.println("请输入修改后的歌曲名称");
											name = input.next();
											System.out.println("请输入修改后的演唱者");
											singer = input.next();
											Song song = new Song(id, name, singer);
											for (PlayList pl : plc.getPlayListMap().values()) {
												pl.updateSong(id, song);
											}
										}
										break;
									}
									// 删除播放列表中的歌曲
									case 6: {
										System.out.println("删除播放列表中的歌曲");
										System.out.println("请输入要删除的歌曲id");
										String id;
										id = input.next();
										if (plc.searchPlayListByName("主播放列表").searchSongById(id) == null) {
											System.out.println("该歌曲不存在！");
										} else {
											for (PlayList pl : plc.getPlayListMap().values()) {
												pl.deleteSong(id);
											}
											System.out.println("删除成功！");
										}
										break;
									}

									// 显示播放列表中的所有歌曲
									case 7: {
										System.out.println("显示播放列表中的所有歌曲");
										System.out.println("请输入播放列表名称");
										String playListName = input.next();
										if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在！");
										} else {
											plc.searchPlayListByName(playListName).displayAllSong();
										}
										break;
									}

									// 导出歌单
									case 8: {
										System.out.println("导出歌单");
										System.out.println("请输入要导出的歌单名称");
										String playListName = input.next();
										if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在！");
										} else {
											plc.searchPlayListByName(playListName).exportPlayList();
										}
										break;
									}
									case 9: {
										flagPlayList = true;
										break;
									}
									}
								}
								if (flagPlayList) {
									break;
								}
							} catch (InputMismatchException e) {
								// TODO Auto-generated catch block
								System.out.println("请输入正整数");
								input.next();
								continue;
							}
						}
						break;
					}
					// 进入播放器管理
					case 2:
						boolean flagPlayListCollection = false;// 跳出播放器管理
						while (true) {
							try {
								infoPlayListCollection();
								flagPlayListCollection = false;
								info = input.nextInt();
								if (info < 1 || (info > 4 && info != 9)) {
									System.out.println("请输入正确的数字！");
								} else {
									switch (info) {

									// 向播放器添加播放列表
									case 1: {
										System.out.println("向播放器添加播放列表");
										System.out.println("请输入要添加的播放列表名称");
										String playListName = input.next();
										if (plc.searchPlayListByName(playListName) != null) {
											System.out.println("该播放列表已经存在");
										} else {
											PlayList playList = new PlayList();
											playList.setPlayListName(playListName);
											plc.addPlayList(playList);
										}
										break;
									}

									// 从播放器删除播放列表
									case 2: {
										System.out.println("从播放器删除播放列表");
										System.out.println("请输入要删除的播放列表名称");
										String playListName = input.next();
										if (playListName.equals("主播放列表")) {
											System.out.println("主播放列表不能删除哦");
										} else if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在");
										} else {
											plc.deletePlayList(playListName);
										}
										break;
									}

									// 通过名字查询播放列表信息
									case 3: {
										System.out.println("通过名字查询播放列表");
										System.out.println("请输入要查询的播放列表名称");
										String playListName = input.next();
										if (plc.searchPlayListByName(playListName) == null) {
											System.out.println("该播放列表不存在");
										} else {
											System.out.println(plc.searchPlayListByName(playListName));
										}
										break;
									}

									// 显示所有播放列表名称
									case 4: {
										System.out.println("显示所有播放列表名称");
										plc.displayPlayListName();
										break;
									}
									case 9: {
										flagPlayListCollection = true;
										break;
									}
									}
								}
								if (flagPlayListCollection) {
									break;
								}
							} catch (InputMismatchException e) {
								// TODO Auto-generated catch block
								System.out.println("请输入正整数");
								input.next();
								continue;
							}
						}
						break;
					// 跳出主菜单循环
					case 0:
						flagMain = true;
						break;
					}
				}
				if (flagMain) {
					break;
				}
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				System.out.println("请输入正整数");
				input.next();
				continue;
			}
		}
		input.close();
	}
}
