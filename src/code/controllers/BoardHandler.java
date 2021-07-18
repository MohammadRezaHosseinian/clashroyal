package code.controllers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;


public class BoardHandler {
    private Canvas board;
    private final GraphicsContext graphics;
    private final double CANVAS_WIDTH ;
    private final double CANVAS_HEIGHT ;


    public BoardHandler(Canvas canvas){
        this.board = canvas;
        this.CANVAS_HEIGHT = this.board.getHeight();
        this.CANVAS_WIDTH = this.board.getWidth();
        this.graphics = canvas.getGraphicsContext2D();
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

    public void initBoard(){
        this.drawGrounds();
        this.drawRiver();
        this.drawBridges();
        this.drawUpSideCastles();
        this.drawDownSideCastles();
        drawUpSideCastlesQueenLeft();
        drawUpSideCastlesQueenRight();
        drawDownSideCastlesQueenLeft();
        drawDownSideCastlesQueenRight();
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
}
