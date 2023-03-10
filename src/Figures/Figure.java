package Figures;

import java.awt.*;

public interface Figure {

    //protected ArrayList<Figure> figures = new ArrayList<>();
    //public abstract void paintComponent(Graphics g);

    public abstract void drawComponent(Graphics g, int pos_x, int pos_y, int dim_x, int dim_y);

    public abstract void drawComponent(Graphics g, int pos_x, int pos_y, int dim_x, int dim_y, Color color);

    //public abstract void paintComponent(Graphics g);

}
