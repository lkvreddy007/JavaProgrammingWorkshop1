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
	
	public static char[] makeAMove(char sign,char[] board) {
		char[] temp=board;
		System.out.println("Enter the position(1 to 9) to mark");
		int num= sc.nextInt();
		if(temp[num]==' ') {
			temp[num]=sign;
			printBoard(temp);
		}
		else {
			System.out.println("Position is not empty");
			printBoard(temp);
			makeAMove(sign,temp);
		}
		return temp;
	}
	
	public static char[] checkAndMakeMove(String turn,char[] board) {
		char charVariable=' ';
		if(turn=="player") {
			charVariable=PLAYER;
		}
		else {
			charVariable=COMPUTER;
		}
		for(int i=1;i<10;i++) {
			if(board[i]==' ') {
				System.out.println("Tip:: Position "+i+" is empty");
			}
		}
		
		return makeAMove(charVariable,board);
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
	
	public static boolean winCondition(char[] board){
		String win="";
		String playerVal=String.valueOf(PLAYER);
		String playerWin=playerVal+playerVal+playerVal;
		String compVal=String.valueOf(COMPUTER);
		String compWin=compVal+compVal+compVal;
		
		for(int i=1;i<10;i++) {
			if(i==1) {
				win=String.valueOf(board[1])+String.valueOf(board[2])+String.valueOf(board[3]);
			}
			else if(i==2) {
				win=String.valueOf(board[4])+String.valueOf(board[5])+String.valueOf(board[6]);
			}
			else if(i==3) {
				win=String.valueOf(board[7])+String.valueOf(board[8])+String.valueOf(board[9]);
			}
			else if(i==4) {
				win=String.valueOf(board[1])+String.valueOf(board[4])+String.valueOf(board[7]);
			}
			else if(i==5) {
				win=String.valueOf(board[2])+String.valueOf(board[5])+String.valueOf(board[8]);
			}
			else if(i==6) {
				win=String.valueOf(board[3])+String.valueOf(board[6])+String.valueOf(board[9]);
			}
			else if(i==7) {
				win=String.valueOf(board[1])+String.valueOf(board[5])+String.valueOf(board[9]);
			}
			else if(i==8) {
				win=String.valueOf(board[3])+String.valueOf(board[5])+String.valueOf(board[7]);
			}
			
			if(win.equals(playerWin)) {
				//System.out.println("Player has won");
				return true;
			}
			else if(win.equals(compWin)) {
				//System.out.println("Computer has won");
				return true;
			}
		}
		return false;
	}
	
	public static boolean tieCondition(char[] board) {
		for(int i=1;i<10;i++) {
			if(board[i]==' ') {
				return false;
			}
		}
		System.out.println("Draw");
		return true;
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
	
	public static int computerPlay(char[] board) {
		char charVariable=COMPUTER;
		int num=0;
		char[] b=board;
		for(int i=1;i<10;i++) {
			if(b[i]==' ') {
				b[i]=charVariable;
				if(winCondition(b)) {
					num=i;
				}
				b[i]=' ';
			}
		}
		return num;
	}
	
	public static int winBlock(char[] board) {
		char opponentSign=PLAYER;
		int num=0;
		for(int i=1;i<10;i++) {
			if(board[i]==' ') {
				board[i]=opponentSign;
				if(winCondition(board)) {
					num=i;
				}
				board[i]=' ';
			}
		}
		return num;
	}
	
	public static int takeCorner(char[] board) {
		int[] corners= {1,3,7,9};
		int selectedCorner=0;
		for(int i:corners) {
			if(board[i]==' ') {
				selectedCorner=i;
				break;
			}
		}
		return selectedCorner;
	}
	
	public static int takeCentre(char[] board) {
		int centre=0;
		if(board[5]==' ') {
			centre=5;
		}
		return centre;
	}
	
	public static int takeAvailableSides(char[] board) {
		int cellNum=0;
		int[] sides= {2,4,6,8};
		for(int i:sides) {
			if(board[i]==' ') {
				cellNum=i;
				break;
			}
		}
		return cellNum;
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
		while(!winCondition(BOARD)&&!tieCondition(BOARD)) {
			System.out.println(turn+"'s turn");
			if(turn=="computer") {
				int num=computerPlay(BOARD);
				if(num==0) {
					int n= winBlock(BOARD);
					if(n==0) {
						int selectedCorner=takeCorner(BOARD);
						if(selectedCorner==0) {
							int centre=takeCentre(BOARD);
							if(centre==0) {
								int sideCell=takeAvailableSides(BOARD);
								if(sideCell==0) {
									
								}
								else{
									BOARD[sideCell]=COMPUTER;
								}
							}
							else {
								BOARD[centre]=COMPUTER;
							}
						}
						else {
							BOARD[selectedCorner]=COMPUTER;
						}
					}
					else {
						BOARD[n]=COMPUTER;
					}
				}
				else {
					BOARD[num]=COMPUTER;
				}
				printBoard(BOARD);
				if(winCondition(BOARD)) {
					System.out.println("Computer has Won");
				}
			}
			else {
				checkAndMakeMove(turn,BOARD);
				if(winCondition(BOARD)) {
					System.out.println("Player has Won");
				}
			}
			turn=changeTurn(turn);
		}
	}
}