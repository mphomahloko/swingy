package za.co.wethinkcode.app.artifacts;

import za.co.wethinkcode.app.model.Hero;

import java.util.Random;

public class Artifacts {
	private final Hero _hero;

	public Artifacts(Hero hero) {
		this._hero = hero;
		Random r = new Random();
		int s = r.nextInt(3);

		if (s == 0) _armor();
		if (s == 1) _helm();
		if (s == 2) _weapon();
	}

	private void _armor() {
		_hero.setHeroDefence(_hero.getHeroDefence() + 5);
		_hero.setHeroArtifact("Armor");
	}

	private void _helm() {
		_hero.setHeroHP(_hero.getHeroHP() + 2);
		_hero.setHeroArtifact("Helm");
	}

	private void _weapon() {
		_hero.setHeroAttack(_hero.getHeroAttack() + 8);
		_hero.setHeroArtifact("Weapon");
	}
}
