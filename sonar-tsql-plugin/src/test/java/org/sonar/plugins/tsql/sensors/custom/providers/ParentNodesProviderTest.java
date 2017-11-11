package org.sonar.plugins.tsql.sensors.custom.providers;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;
import org.sonar.plugins.tsql.helpers.Antlr4Utils;
import org.sonar.plugins.tsql.rules.custom.Rule;
import org.sonar.plugins.tsql.sensors.custom.ParsedNode;
import org.sonar.plugins.tsql.sensors.custom.nodes.ParentNodesProvider;

public class ParentNodesProviderTest {

	@Test
	public void test() {
		ParentNodesProvider provider = new ParentNodesProvider();
		Assert.assertEquals(0, provider.getNodes(null).length);
	}

	@Test
	public void test2() {
		ParseTree tree = Antlr4Utils.get("select * from dbo.test");
		Rule rule = new Rule();
		ParentNodesProvider provider = new ParentNodesProvider();
		ParsedNode node = new ParsedNode(tree.getChild(0).getChild(0), rule, "test");
		Assert.assertEquals(2, provider.getNodes(node).length);
	}

}
