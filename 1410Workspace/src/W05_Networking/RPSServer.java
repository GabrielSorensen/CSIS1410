// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RPSServer.java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RPSServer
{

    public RPSServer()
    {
        wins = 0;
        losses = 0;
        tie = 0;
        try
        {
            System.out.println("Server Starting on port 12345");
            ServerSocket s = new ServerSocket(12345, 100);
            System.out.println("Please start the client and enter a move: Rock, Paper or Scissors");
            Socket socket = s.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            for(int i = 0; i < 50; i++)
            {
                String move = in.readObject().toString();
                System.out.println((new StringBuilder("Client entered ")).append(move).toString());
                if(move.equalsIgnoreCase("Rock"))
                {
                    wins++;
                    System.out.println("\tSending Paper to Client, I won");
                    out.writeObject("Paper");
                } else
                if(move.equalsIgnoreCase("Paper"))
                {
                    wins++;
                    System.out.println("\tSending Scissors to Client, I won");
                    out.writeObject("Scissors");
                } else
                if(move.equalsIgnoreCase("Scissors"))
                {
                    wins++;
                    System.out.println("\tSending Rock to Client, I won");
                    out.writeObject("Rock");
                } else
                {
                    out.writeObject((new StringBuilder("Unknown Move, ")).append(move).append(" Exiting early").toString());
                    System.out.println((new StringBuilder("Unknown Move ")).append(move).append(" Exiting early").toString());
                    System.exit(1);
                }
                int next = (int)(Math.random() * 3D);
                if(next == 0)
                {
                    System.out.println("Sending Rock to Client");
                    out.writeObject("Rock");
                    out.flush();
                } else
                if(next == 1)
                {
                    System.out.println("Sending Paper to Client");
                    out.writeObject("Paper");
                    out.flush();
                } else
                if(next == 2)
                {
                    System.out.println("Sending Scissors to Client");
                    out.writeObject("Scissors");
                    out.flush();
                } else
                {
                    System.out.println("BAD RANDOM NUMBER WITH SERVER CODE.  GET DR B TO FIX IT");
                    System.exit(1);
                }
                Object o = in.readObject();
                if(o == null)
                    move = "null from client code";
                else
                    move = o.toString();
                checkAndIncrement(next, move);
            }

            System.out.println((new StringBuilder("Computer Ties: ")).append(tie).toString());
            System.out.println((new StringBuilder("Computer Wins: ")).append(wins).toString());
            System.out.println((new StringBuilder("Computer Losses: ")).append(losses).toString());
            s.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void checkAndIncrement(int me, String you)
    {
        if(me == 0)
        {
            if(you.equals("Rock"))
            {
                System.out.println("\tTie");
                tie++;
            } else
            if(you.equals("Paper"))
            {
                System.out.println("\tI lose");
                losses++;
            } else
            if(you.equals("Scissors"))
            {
                System.out.println("\tI Win Again");
                wins++;
            } else
            {
                System.out.println((new StringBuilder("Unknown Move ")).append(you).append(" Exiting early").toString());
                System.exit(1);
            }
        } else
        if(me == 1)
        {
            if(you.equals("Rock"))
            {
                System.out.println("\tI Win Again");
                wins++;
            } else
            if(you.equals("Paper"))
            {
                System.out.println("\tTie");
                tie++;
            } else
            if(you.equals("Scissors"))
            {
                System.out.println("\tI lose");
                losses++;
            } else
            {
                System.out.println((new StringBuilder("Unknown Move ")).append(you).append(" Exiting early").toString());
                System.exit(1);
            }
        } else
        if(me == 2)
        {
            if(you.equals("Rock"))
            {
                System.out.println("\tI lose");
                losses++;
            } else
            if(you.equals("Paper"))
            {
                System.out.println("\tI Win Again");
                wins++;
            } else
            if(you.equals("Scissors"))
            {
                System.out.println("\tTie");
                tie++;
            } else
            {
                System.out.println((new StringBuilder("Unknown Move ")).append(you).append(" Exiting early").toString());
                System.exit(1);
            }
        } else
        {
            System.out.println("BAD RANDOM NUMBER WITH SERVER CODE.  GET DR B TO FIX IT");
            System.exit(1);
        }
    }

    public static void main(String args[])
    {
        RPSServer s = new RPSServer();
    }

    private int wins;
    private int losses;
    private int tie;
}
