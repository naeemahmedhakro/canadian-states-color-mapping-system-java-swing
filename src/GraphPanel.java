package canadian_states_color_mapping_system;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SuppressWarnings("serial")
class GraphPanel extends JPanel {

    private List<Vertex> vertices;
    private List<Edge> edges;
    private HashMap<String,Color> mapColors;

    public GraphPanel(HashMap<String,Color> map) {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        mapColors = map;

        // Add vertices statically with names
        vertices.add(new Vertex("BC", 200, 80)); //vertex 1
        vertices.add(new Vertex("NB", 300, 60)); //vertex 2
        vertices.add(new Vertex("MB", 400, 50)); //vertex 3
        vertices.add(new Vertex("NL", 500, 65)); //vertex 4
        vertices.add(new Vertex("AB", 600, 110)); //vertex 5
        vertices.add(new Vertex("ON", 640, 210)); //vertex 6
        vertices.add(new Vertex("NU", 600, 330)); //vertex 7
        vertices.add(new Vertex("NT", 500, 400)); //vertex 8
        vertices.add(new Vertex("NS", 400, 430)); //vertex 9
        vertices.add(new Vertex("PE", 270, 400)); //vertex 10
        vertices.add(new Vertex("QC", 180, 350)); //vertex 11
        vertices.add(new Vertex("SK", 150, 250)); //vertex 12
        vertices.add(new Vertex("YT", 150, 150)); //vertex 13

        // Add edges statically
        //BC
        edges.add(new Edge(vertices.get(0), vertices.get(4)));
        edges.add(new Edge(vertices.get(0), vertices.get(7)));
        edges.add(new Edge(vertices.get(0), vertices.get(12)));
        
        //NB
        edges.add(new Edge(vertices.get(1), vertices.get(8)));
        edges.add(new Edge(vertices.get(1), vertices.get(9)));
        edges.add(new Edge(vertices.get(1), vertices.get(10)));
        
        //MB
        edges.add(new Edge(vertices.get(2), vertices.get(5)));
        edges.add(new Edge(vertices.get(2), vertices.get(6)));
        edges.add(new Edge(vertices.get(2), vertices.get(11)));
        
        //NL
        edges.add(new Edge(vertices.get(3), vertices.get(10)));
        
        //AB
        edges.add(new Edge(vertices.get(4), vertices.get(11)));
        edges.add(new Edge(vertices.get(4), vertices.get(7)));
        
        //ON
        edges.add(new Edge(vertices.get(5), vertices.get(10)));
        
        //NU
        edges.add(new Edge(vertices.get(6), vertices.get(7)));
        
        //NT
        edges.add(new Edge(vertices.get(7), vertices.get(11)));
        edges.add(new Edge(vertices.get(7), vertices.get(12)));
        
        //NS
        edges.add(new Edge(vertices.get(8), vertices.get(9)));
        
        //No need to define PE, QC, SK, and YT Because their connections are already build for visual purpose
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw edges
        g.setColor(Color.BLACK);
        for (Edge edge : edges) {
            g.drawLine(edge.getStart().getX(), edge.getStart().getY(), edge.getEnd().getX(), edge.getEnd().getY());
        }

        // Draw vertices with names
        System.out.println(mapColors);
        for (Vertex vertex : vertices) {
        	Color color = mapColors.get(vertex.getName().toString());
            g.setColor(color);
            g.fillOval(vertex.getX() - 7, vertex.getY() -7, 15, 15);
            g.drawString(vertex.getName(), vertex.getX() -10, vertex.getY() - 10);
        }        
    }
}

class Vertex {
    private String name;
    private int x;
    private int y;

    public Vertex(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Edge {
    private final Vertex start;
    private final Vertex end;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }
}
