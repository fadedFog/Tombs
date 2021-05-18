package ru.fadedfog.tombs.asset.level.element;

import ru.fadedfog.tombs.asset.level.element.surface.Balk;
import ru.fadedfog.tombs.asset.level.element.surface.Block;
import ru.fadedfog.tombs.asset.level.element.surface.BlockInvisible;
import ru.fadedfog.tombs.asset.level.element.surface.OldPlatform;
import ru.fadedfog.tombs.asset.level.element.surface.Platform;
import ru.fadedfog.tombs.asset.level.element.surface.TypeSurface;
import ru.fadedfog.tombs.exception.NoSurfaceFoundException;

public class FactorySurface {
	
	public static Surface makeSurface(TypeSurface typeSurface) 
			throws NoSurfaceFoundException{
		switch (typeSurface) {
			case BALK:
				return new Balk();
			case BLOCK:
				return new Block();
			case BLOCK_INVISIBLE:
				return new BlockInvisible();
			case PLATFORM:
				return new Platform();
			case OLD_PLATFORM:
				return new OldPlatform();
			default:
				throw new NoSurfaceFoundException(typeSurface);
		}
	}
	
}
