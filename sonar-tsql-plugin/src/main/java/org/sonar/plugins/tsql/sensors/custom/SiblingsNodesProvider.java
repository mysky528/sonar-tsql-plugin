package org.sonar.plugins.tsql.sensors.custom;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

public class SiblingsNodesProvider implements INodesProvider {

	@Override
	public ParsedNode[] getNodes(ParsedNode node) {
		List<ParsedNode> nodes = new ArrayList<ParsedNode>();

		final ParseTree item = node.getItem();

		final ParseTree parent = item.getParent();
		if (parent == null) {
			return new ParsedNode[0];
		}
		int c = parent.getChildCount();
		for (int i = 0; i < c; i++) {
			final ParseTree child = parent.getChild(i);
			nodes.add(new ParsedNode(child, node.getRule(), node.getRepository()));
		}

		return nodes.toArray(new ParsedNode[0]);
	}

}