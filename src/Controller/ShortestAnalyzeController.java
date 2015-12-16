/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Legacy.Legacy;
import Model.Node;
import Model.Project;
import Model.ShortestAnalysis;
import java.util.List;

/**
 *
 * @author ruben
 */
public class ShortestAnalyzeController {

	private Project project;
	private Node startNode;
	private Node endNode;

	public void initiation() {
		this.project = ContextController.getOpenProject();
	}

	public Boolean setNodes(Node startNode, Node endNode) {
		this.startNode = startNode;
		this.endNode = endNode;
		return this.startNode.equals(startNode) && this.endNode.equals(endNode);
	}

	public List<Node> getNodes() {
		return this.project.getRoadNetwork().getNodes();
	}

	public Boolean save(String filePath) {
		ShortestAnalysis shortestAnalysis = new ShortestAnalysis();
		String result = shortestAnalysis.
			analyze(this.project.getRoadNetwork(), this.startNode, this.endNode);
		return Legacy.export(filePath, result);
	}

}
