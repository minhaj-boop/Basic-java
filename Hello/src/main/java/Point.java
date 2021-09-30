/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Point {
    int x;
    int y;
    Point(int px, int py){
        x = px;
        y = py;
    }
    double getDistance(Point q){
        Point p = this;
        int dx = p.x - q.x;
        int dy = p.y - q.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
