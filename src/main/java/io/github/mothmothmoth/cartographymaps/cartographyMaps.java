package io.github.mothmothmoth.cartographymaps;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class cartographyMaps implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Cartography Maps");

	@Override
	public void onInitialize() {
		LOGGER.info("maps are making :3");
	}
}
