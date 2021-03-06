package com.gmail.perhapsitisyeazz.yeazzymail.util;

import com.google.gson.JsonObject;
import com.moderocky.mask.internal.utility.FileManager;
import org.bukkit.entity.Player;

import java.io.File;

import static com.gmail.perhapsitisyeazz.yeazzymail.YeazzyMail.storingFile;

public class JoinFile {

	public JsonObject getJsonObject(Player player) {
		JsonObject object = new JsonObject();
		object.addProperty("UniqueID", player.getUniqueId().toString());
		object.addProperty("Username", player.getName());
		object.addProperty("hasEmailToggle", true);
		object.add("EmailList", new JsonObject());
		return object;
	}

	public void createPlayerFile(Player player) {
		String uniqueID = player.getUniqueId().toString();
		if (new File(storingFile + uniqueID).exists()) return;
		String jsonObjectToString = getJsonObject(player).toString();
		FileManager.write(new File(storingFile, uniqueID + ".json"), jsonObjectToString);
	}
}
