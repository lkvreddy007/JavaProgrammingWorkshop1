package com.example;

import java.util.*;

public class TicTacToe {
	static char[] BOARD=new char[10];
	static Scanner sc=new Scanner(System.in);
	static char PLAYER;
	static char COMPUTER;
	
	public static char[] boardCreate() {
		char[] boardloc=new char[10];
		for(int i=0;i<10;i++) {
			boardloc[i]=' ';
		}
		return boardloc;
	}
	
	public static void printBoard(char[] boardPrint) {
		System.out.println(" "+boardPrint[1]+" | "+boardPrint[2]+" | "+boardPrint[3]);
		System.out.println("-----------");
		System.out.println(" "+boardPrint[4]+" | "+boardPrint[5]+" | "+boardPrint[6]);
		System.out.println("-----------");
		System.out.println(" "+boardPrint[7]+" | "+boardPrint[8]+" | "+boardPrint[9]);
		
	}
	
	public static void chooseXO() {
		System.out.println("Choose between x and o");
		char a=sc.next().charAt(0);
		if(a=='x') {
			System.out.println("Player has choosen x");
			PLAYER='x';
			System.out.println("Computer is asssigned o");
			COMPUTER='o';
		}
		else if(a=='o') {
			System.out.println("Player has choosen o");
			PLAYER='o';
			System.out.println("Computer is asssigned x");
			COMPUTER='x';
		}
	}
	
	public static void makeAMove(char sign) {
		System.out.println("Enter the position(1 to 9) to mark");
		int num= sc.nextInt();
		if(BOARD[num]==' ') {
			BOARD[num]=sign;
			printBoard(BOARD);
		}
		else {
			System.out.println("Position is not empty");
			printBoard(BOARD);
			makeAMove(sign);
		}
		
	}
	
	public static void checkAndMakeMove(String turn) {
		for(int i=1;i<10;i++) {
			if(BOARD[i]==' ') {
				System.out.println("Position "+i+" is empty");
			}
		}
		char charVariable;
		if(turn=="player") {
			charVariable=PLAYER;
		}
		else {
			charVariable=COMPUTER;
		}
		makeAMove(charVariable);
		
	}
	
	public static int whoGoesFirst() {
		int toss=(int) Math.floor(Math.random()*10)%2;
		if(toss==0) {
			System.out.println("Computer goes First");
		}
		else if(toss==1){
			System.out.println("Player goes First");
		}
		return toss;
	}
	
	public static boolean winCondition(){
		String win="";
		String playerVal=String.valueOf(PLAYER);
		String playerWin=playerVal+playerVal+playerVal;
		String compVal=String.valueOf(COMPUTER);
		String compWin=compVal+compVal+compVal;
		
		for(int i=1;i<10;i++) {
			if(i==1) {
				win=String.valueOf(BOARD[1])+String.valueOf(BOARD[2])+String.valueOf(BOARD[3]);
			}
			else if(i==2) {
				win=String.valueOf(BOARD[4])+String.valueOf(BOARD[5])+String.valueOf(BOARD[6]);
			}
			else if(i==3) {
				win=String.valueOf(BOARD[7])+String.valueOf(BOARD[8])+String.valueOf(BOARD[9]);
			}
			else if(i==4) {
				win=String.valueOf(BOARD[1])+String.valueOf(BOARD[4])+String.valueOf(BOARD[7]);
			}
			else if(i==5) {
				win=String.valueOf(BOARD[2])+String.valueOf(BOARD[5])+String.valueOf(BOARD[8]);
			}
			else if(i==6) {
				win=String.valueOf(BOARD[3])+String.valueOf(BOARD[6])+String.valueOf(BOARD[9]);
			}
			else if(i==7) {
				win=String.valueOf(BOARD[1])+String.valueOf(BOARD[5])+String.valueOf(BOARD[9]);
			}
			else if(i==8) {
				win=String.valueOf(BOARD[3])+String.valueOf(BOARD[5])+String.valueOf(BOARD[7]);
			}
			
			if(win.equals(playerWin)) {
				System.out.println("Player has won");
				return false;
			}
			else if(win.equals(compWin)) {
				System.out.println("Computer has won");
				return false;
			}
		}
		return true;
	}
	
	public static boolean tieCondition() {
		for(int i=1;i<10;i++) {
			if(BOARD[i]==' ') {
				return true;
			}
		}
		System.out.println("Draw");
		return false;
	}
	
	public static String changeTurn(String currentTurn) {
		String temp;
		if(currentTurn.equals("computer")) {
			temp="player";
		}
		else {
			temp="computer";
		}
		return temp;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		BOARD=boardCreate();
		chooseXO();
		printBoard(BOARD);
		String turn;
		int toss=whoGoesFirst();
		if(toss ==0) {
			turn="computer";
		}
		else {
			turn="player";
		}
		while(winCondition()&&tieCondition()) {
			System.out.println(turn+"'s turn");
			checkAndMakeMove(turn);
			turn=changeTurn(turn);
		}
	}
}