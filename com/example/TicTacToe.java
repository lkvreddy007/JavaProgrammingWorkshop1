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
	
	public static void makeAMove() {
		System.out.println("Enter the position(1-9) to mark");
		int num= sc.nextInt();
		if(BOARD[num]==' ') {
			BOARD[num]=PLAYER;
			printBoard(BOARD);
		}
		else {
			System.out.println("Position is not empty");
			printBoard(BOARD);
			makeAMove();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		BOARD=boardCreate();
		chooseXO();
		printBoard(BOARD);
		makeAMove();
		makeAMove();
	}
}