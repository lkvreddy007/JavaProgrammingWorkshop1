package com.example;

public class TicTacToe {
	static char[] board=new char[10];
	
	public static char[] boardCreate() {
		for(int i=0;i<10;i++) {
			board[i]=' ';
		}
		return board;
	}
	public static void printBoard(char[] boardPrint) {
		for(int i=1;i<10;i++) {
			System.out.println(boardPrint[i]);
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		boardCreate();
	}
}
