package code.controllers;

import code.heros.Position;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class BoardHandler {
    private Canvas board;
    private final GraphicsContext graphics;
    private final double CANVAS_WIDTH ;
    private final double CANVAS_HEIGHT ;
    private Image img;


    public BoardHandler(Canvas canvas){
        this.board = canvas;
        this.CANVAS_HEIGHT = this.board.getHeight();
        this.CANVAS_WIDTH = this.board.getWidth();
        this.graphics = canvas.getGraphicsContext2D();
//        this.initBoard();
        this.img = new Image("res//drawable//base.png");
    }

    private void drawGrounds(){
        Image tileImage;
        int randomGroundImage;
        Random random = new Random();
        for (int j = 0; j < this.CANVAS_HEIGHT / Defaults.TILE_HEIGHT; j++) {
            for (int i = 0; i < this.CANVAS_WIDTH / Defaults.TILE_WIDTH; i++) {
                randomGroundImage = random.nextInt(Defaults.TILES_KIND_COUNT);
                tileImage = new Image(Defaults.GROUNDS_URIS[randomGroundImage]);
                this.graphics.drawImage(tileImage, i * Defaults.TILE_WIDTH, j * Defaults.TILE_HEIGHT, Defaults.TILE_WIDTH, Defaults.TILE_HEIGHT);
            }
        }
    }

    public void drawBase(){
        this.graphics.drawImage(this.img,0,0,this.CANVAS_WIDTH, this.CANVAS_HEIGHT);
    }

    public void initBoard(){
        this.drawGrounds();
        this.drawRiver();
        this.drawBridges();
//        this.drawUpSideCastles();
//        this.drawDownSideCastles();
//        drawUpSideCastlesQueenLeft();
//        drawUpSideCastlesQueenRight();
//        drawDownSideCastlesQueenLeft();
//        drawDownSideCastlesQueenRight();
        this.saveAsImage();
    }

    private void saveAsImage() {

            WritableImage wi = new WritableImage((int)CANVAS_WIDTH,(int)CANVAS_HEIGHT);

            try {
                SnapshotParameters sp = new SnapshotParameters();
                sp.setFill(Color.TRANSPARENT);
                ImageIO.write(SwingFXUtils.fromFXImage(board.snapshot(sp,wi),null),"png",new File("src//res//drawable//base.png"));
            } catch ( IOException e) {
                e.printStackTrace();
            }
    }

    private void drawDownSideCastles() {
        double kingCastleWidth = this.CANVAS_WIDTH / 2;
        double kingCastleHeight = this.CANVAS_HEIGHT - this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[1]), kingCastleWidth, kingCastleHeight, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);
    }

    private void drawDownSideCastlesQueenLeft() {
        double kingCastleWidth = this.CANVAS_WIDTH / 4 ;
        double kingCastleHeght = this.CANVAS_HEIGHT -  this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[2]), kingCastleWidth, kingCastleHeght, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);


    }

    private void drawDownSideCastlesQueenRight() {
        double kingCastleWidth = this.CANVAS_WIDTH / 2 + this.CANVAS_WIDTH / 4 ;
        double kingCastleHeght = this.CANVAS_HEIGHT - this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[2]), kingCastleWidth, kingCastleHeght, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);


    }

    private void drawBridges() {
        double startRiverHeight = this.CANVAS_HEIGHT / 2 - this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - (double) Defaults.TILE_HEIGHT / 2;
        double endRiverHeight = this.CANVAS_HEIGHT / 2 + this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - (double) Defaults.TILE_HEIGHT / 2;
        double leftBridgeWidthStart = this.CANVAS_WIDTH / 4 - this.CANVAS_WIDTH * Defaults.BRIDGE_PERCENT;
        double leftBridgeWidthEnd = this.CANVAS_WIDTH / 4 + this.CANVAS_WIDTH * Defaults.BRIDGE_PERCENT;
        double middleWidth = this.CANVAS_WIDTH / 2;
        double imgWidth = (leftBridgeWidthEnd + leftBridgeWidthStart) / 4;
        Image img;
        for (double i = startRiverHeight; i <= endRiverHeight ; i+=Defaults.TILE_HEIGHT) {
            for (int j = 0; j <2 ; j++) {
                img = new Image(Defaults.BRIDGES_URIS[j]);
                this.graphics.drawImage(img, j * imgWidth/2 + leftBridgeWidthStart,i,imgWidth, Defaults.TILE_HEIGHT);
                this.graphics.drawImage(img, j * imgWidth/2 + leftBridgeWidthStart + middleWidth,i,imgWidth, Defaults.TILE_HEIGHT);
            }
        }

    }

    private void drawUpSideCastles() {
        double kingCastleWidth = this.CANVAS_WIDTH / 2;
        double kingCastleHeight = this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[0]), kingCastleWidth, kingCastleHeight, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);


    }

    private void drawUpSideCastlesQueenLeft() {
        double kingCastleWidth = this.CANVAS_WIDTH / 4 ;
        double kingCastleHeght = 0 + this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[3]), kingCastleWidth, kingCastleHeght, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);


    }

    private void drawUpSideCastlesQueenRight() {
        double kingCastleWidth = this.CANVAS_WIDTH / 2 + this.CANVAS_WIDTH / 4 ;
        double kingCastleHeght = 0 + this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        this.graphics.drawImage(new Image(Defaults.CASTLES_URIS[3]), kingCastleWidth, kingCastleHeght, Defaults.KING_CASTLE_WIDTH, Defaults.KING_CASTLE_HEIGHT);


    }

    private void drawRiver() {
        Image tileImage;
        int randomGroundImage;
        Random random = new Random();
        double startRiverHeight = this.CANVAS_HEIGHT / 2 - this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - (double) Defaults.TILE_HEIGHT / 2;
        double endRiverHeight = this.CANVAS_HEIGHT / 2 + this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - (double) Defaults.TILE_HEIGHT / 2;
//        System.out.println(String.format("height : %f\nstart : %f\nend : %f",this.CANVAS_HEIGHT, startRiverHeight, endRiverHeight));
        for (double i = startRiverHeight; i <= endRiverHeight; i+= Defaults.TILE_HEIGHT) {
            for (int j = 0; j < this.CANVAS_WIDTH / Defaults.TILE_WIDTH; j++) {
                randomGroundImage = random.nextInt(Defaults.RIVERS_LENGTH);
                tileImage = new Image(Defaults.RIVERS_URIS[randomGroundImage]);
                this.graphics.drawImage(tileImage, j*Defaults.TILE_WIDTH, i, Defaults.TILE_WIDTH, Defaults.TILE_HEIGHT);
            }
        }
    }

    public Position getLeftUpSideBridgePos(){
        double riverHeight = this.CANVAS_HEIGHT / 2 - this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - Defaults.TILE_HEIGHT * 2.3 ;
        double leftBridgeWidth = this.CANVAS_WIDTH / 4 - this.CANVAS_WIDTH * Defaults.BRIDGE_PERCENT + Defaults.TILE_WIDTH * 1.5;
        return  new Position(leftBridgeWidth, riverHeight);
    }

    public Position getLeftDownSideBridgePos(){
        double riverHeight = this.CANVAS_HEIGHT / 2 + this.CANVAS_HEIGHT * Defaults.RIVER_PERCENT_PER_MAP_SIDE - Defaults.TILE_HEIGHT * 1.3 ;
        double leftBridgeWidth = this.CANVAS_WIDTH / 4 + this.CANVAS_WIDTH * Defaults.BRIDGE_PERCENT - Defaults.TILE_WIDTH * 2.5 ;
        return new Position(leftBridgeWidth,riverHeight);

    }

    public Position getRightDownSideBridgePos(){
        Position pos = this.getLeftDownSideBridgePos();
        pos.setX(pos.getX() + CANVAS_WIDTH / 2);
        return pos;
    }

    public Position getRightUpSideBridgePos(){
        Position pos = this.getLeftUpSideBridgePos();
        pos.setX(pos.getX() + CANVAS_WIDTH / 2);
        return pos;
    }

    public Position getLeftDownSideCastlePos(){
        double CastleWidth = this.CANVAS_WIDTH / 4;
        double CastleHeight = this.CANVAS_HEIGHT - this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        return new Position(CastleWidth,CastleHeight);

    }

    public Position getRightDownSideCastlePos(){
        double CastleWidth = this.CANVAS_WIDTH /2 + this.CANVAS_WIDTH / 4;
        double CastleHeight = this.CANVAS_HEIGHT - this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        return new Position(CastleWidth,CastleHeight);

    }

    public Position getDownSideKingCastlePos(){
        double kingCastleWidth = this.CANVAS_WIDTH /2 ;
        double kingCastleHeight = this.CANVAS_HEIGHT - this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT - Defaults.KING_CASTLE_HEIGHT;
        return new Position(kingCastleWidth,kingCastleHeight);

    }

    public Position getLeftUpSideCastlePos(){
        double CastleWidth = this.CANVAS_WIDTH / 4 ;
        double CastleHeight = 0 + this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        return new Position(CastleWidth,CastleHeight);

    }

    public Position getRightUpSideCastlePos(){
        double CastleWidth = this.CANVAS_WIDTH / 2 + this.CANVAS_WIDTH / 4 ;
        double CastleHeight = 0 + this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        return new Position(CastleWidth,CastleHeight);

    }

    public Position getUpSideKingCastlePos(){
        double kingCastleWidth = this.CANVAS_WIDTH / 2;
        double kingCastleHeight = this.CANVAS_HEIGHT * Defaults.CASTLE_ROW_PERCENT;
        return new Position(kingCastleWidth,kingCastleHeight);

    }


    public double getCANVAS_WIDTH(){
        return this.CANVAS_WIDTH;
    }
}

