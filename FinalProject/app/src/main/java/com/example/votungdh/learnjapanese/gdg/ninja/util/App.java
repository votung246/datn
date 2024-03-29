package com.example.votungdh.learnjapanese.gdg.ninja.util;


import android.app.Application;
import android.content.Context;

import com.example.votungdh.learnjapanese.gdg.ninja.gameinfo.CategoriesInfo;
import com.example.votungdh.learnjapanese.gdg.ninja.gameinfo.QuestInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Application class stand for the current application. This class using to do
 * basic application function or initial the application controller. Class also
 * get application context at normal java code.
 */
public class App extends Application {
	// Application context be private to prevent change this static data.
	private static Context CurrentApp;

	private static List<CategoriesInfo> listCategories = new ArrayList<CategoriesInfo>();

	public static void setListCate(List<CategoriesInfo> listCategories) {
		App.listCategories = listCategories;
	}

	public static List<CategoriesInfo> getListCategories() {
		return listCategories;
	}

	public static CategoriesInfo getCategoryById(int categoryId) {
		for (CategoriesInfo item : listCategories) {
			if (item.getCateId() == categoryId) {
				return item;
			}
		}
		throw new IllegalArgumentException("Do not have this category ID: "
				+ categoryId);
	}

	public static List<QuestInfo> getListQuestById(int categoryId) {
		return getCategoryById(categoryId).getListQuest();
	}

	public static QuestInfo getQuestById(int questId, int categoryId) {
		List<QuestInfo> listQuest = getListQuestById(categoryId);
		for (QuestInfo item : listQuest) {
			if (item.getQuestId() == questId) {
				return item;
			}
		}
		throw new IllegalArgumentException("Do not have this quest ID: "
				+ questId);
	}

	// Application config

	/** Get current application context. */
	public static final Context getContext() {
		return CurrentApp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		if (CurrentApp == null) {
			CurrentApp = this;
		}
	}
}