package org.sonar.plugins.tsql.antlr.lines;

import org.sonar.plugins.tsql.antlr.nodes.IParsedNode;
import org.sonar.plugins.tsql.antlr.nodes.ParsedNode;

public interface ILinesProvider {
	int getLine(IParsedNode node);
}
