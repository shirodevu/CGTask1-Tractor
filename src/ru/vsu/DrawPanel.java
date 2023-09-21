package ru.vsu;

import ru.vsu.elements.*;
import ru.vsu.logic.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DrawPanel extends JPanel implements ActionListener {
	static final Random random = new Random();
	private final Sun sun;
	private final Timer timer;
	private final Queue<Cloud> clouds;
	private final Queue<Tree> trees;
	private final Wheel w1, w2, w3, w4;
	private final TractorBody tractorBody;

	public DrawPanel(final int timerDelay) {
		trees = new ConcurrentLinkedQueue<>();
		clouds = new ConcurrentLinkedQueue<>();
		tractorBody = new TractorBody(0, 0);
		for (int i = 0; i <= 3; i++) {
			Cloud cloud = new Cloud(
					900 - i * 200 + random.nextInt(50),
					100 + random.nextInt(100),
					160 + random.nextInt(50),
					100 + random.nextInt(50));
			clouds.add(cloud);
		}

		timer = new Timer(timerDelay, this);
		timer.start();

		w1 = new Wheel(230, 430, 40, 10);
		w2 = new Wheel(360, 430, 40, 10);
		w3 = new Wheel(495, 420, 50, 15);
		w4 = new Wheel(680, 430, 40, 10);

		trees.add(new AppleTree(800, 190, 60, 10, 20));
		trees.add(new LeafTree(120, 220, 70, 5, 20));

		sun = new Sun(250, 100, 40, 70, 40);
	}

	private static void drawBackground(Graphics2D g) {
		// sky
		g.setColor(new Color(165, 221, 238));
		g.fillRect(0, 0, 900, 300);
		// grass
		g.setColor(new Color(118, 200, 91));
		g.fillRect(0, 300, 900, 300);
		// road
		g.setColor(new Color(209, 190, 128));
		g.fillRect(0, 400, 900, 130);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		if (e.getSource() == timer) {
			processClouds();
			processTrees();
			repaint();
		}
	}


	@Override
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawBackground(g);
		sun.draw(g);
		processClouds();
		processTrees();

		for (Cloud cloud : clouds) {
			cloud.move(-4, 0);
			cloud.draw(g);
		}

		for (Tree tree : trees) {
			tree.move(-4, 0);
			tree.draw(g);
		}

		drawTractor(g);
	}

	private void processClouds() {
		for (Iterator<Cloud> iterator = clouds.iterator(); iterator.hasNext(); ) {
			Cloud cloud = iterator.next();
			if (cloud.getX() + cloud.getWidth() < 0) {
				iterator.remove();
				clouds.add(cloudFactory());
			}
		}
	}

	private void processTrees() {
		for (Iterator<Tree> iterator = trees.iterator(); iterator.hasNext(); ) {
			Tree tree = iterator.next();
			if (tree.getX() < 0) {
				iterator.remove();
				trees.add(treeFactory());
			}
		}
	}

	private void drawTractor(Graphics2D g) {
		// hay
		drawHay(g);
		// main tractor body
		tractorBody.draw(g);
		// wheels
		w1.draw(g);
		w2.draw(g);
		w3.draw(g);
		w4.draw(g);

	}

	private void drawHay(Graphics2D g) {
		// hay
		g.setColor(new Color(222, 191, 53));
		g.fillOval(170, 180, 250, 250);
		g.setColor(new Color(91, 61, 42));
		g.fillRect(280, 180, 5, 200);
		g.fillRect(300, 180, 5, 200);
	}

	private Cloud cloudFactory() {
		return new Cloud(
				900,
				100 + random.nextInt(100),
				160 + random.nextInt(50),
				100 + random.nextInt(50));
	}

	private Tree treeFactory() {
		long appleTreesCount = trees.stream()
				.filter(tree -> tree instanceof AppleTree)
				.count();
		long leafTreesCount = trees.stream()
				.filter(tree -> tree instanceof LeafTree)
				.count();
		if (appleTreesCount < leafTreesCount) {
			return new AppleTree(900, 190, 60, 10, 20);
		} else if (appleTreesCount > leafTreesCount) {
			return new LeafTree(900, 220, 70, 5, 20);
		} else {
			return new AppleTree(900, 190, 60, 10, 20);
		}
	}
}
