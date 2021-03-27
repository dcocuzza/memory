import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoryFrame extends JFrame implements ActionListener, MouseListener{
	
    private int r = 4;
    private int c = 4;
	private JButton M[][] = new JButton[r][c];
	private int turno;
	private int mat[][];
	private JButton btnRigioca = new JButton("RIGIOCA");
	private JPanel pnl = new JPanel();
	private int I;
	private int J;
	
	public MemoryFrame() {
		super("Memory Game");
		Container C = this.getContentPane();
		C.setLayout(new BorderLayout());
		pnl.setLayout(new GridLayout(r,c));
		int i,j, i1, j1, i2, j2;;
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
			{
				M[i][j] = new JButton();
				M[i][j].addActionListener(this);
				M[i][j].addMouseListener(this);
				M[i][j].setBackground(Color.WHITE);
				pnl.add(M[i][j]);
			}
		btnRigioca.addActionListener(this);
		btnRigioca.setBackground(Color.LIGHT_GRAY);
		C.add(pnl, BorderLayout.CENTER);
		C.add(btnRigioca, BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);
		turno = 1;
		mat = new int [r][c];
		for(i = 0; i<4; i++)
			for(j=0; j<4; j++)
				mat[i][j] = 0;
		
		for(i=1; i<9; i++)
		{
			i1 = (int)(Math.random() * 4);
			j1 = (int)(Math.random() * 4);
			i2 = (int)(Math.random() * 4);
			j2 = (int)(Math.random() * 4);
			if((i1 == i2 && j1 == j2) || (mat[i1] [j1] != 0 || mat[i2][j2] != 0))
			{
				i--;
				continue;
			}
			else
			{
				mat[i1][j1] = i;
				mat[i2][j2] = i;
			}

		}
		
		for(i=0; i<4; i++)
		{
			for(j=0; j<4; j++)
				System.out.print(mat[i][j]+" ");
			
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRigioca)
		{
			int i, j, i1, j1, i2, j2;
			turno = 1;
			for(i = 0; i<4; i++)
				for(j=0; j<4; j++)
					mat[i][j] = 0;
			
			for(i=1; i<9; i++)
			{
				i1 = (int)(Math.random() * 4);
				j1 = (int)(Math.random() * 4);
				i2 = (int)(Math.random() * 4);
				j2 = (int)(Math.random() * 4);
				if((i1 == i2 && j1 == j2) || (mat[i1] [j1] != 0 || mat[i2][j2] != 0))
				{
					i--;
					continue;
				}
				else
				{
					mat[i1][j1] = i;
					mat[i2][j2] = i;
				}

			}
			for(i = 0; i<r; i++)
				for(j=0; j<c; j++)
				{
					M[i][j].setEnabled(true);
					M[i][j].setBackground(Color.WHITE);
				}
			for(i=0; i<4; i++)
			{
				for(j=0; j<4; j++)
					System.out.print(mat[i][j]+" ");
				
				System.out.println();
			}
			System.out.println();
		}
			
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int i,j;
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
				
		if(e.getSource() == M[i][j])
		{
			M[i][j].setEnabled(false);
			
			if(mat[i][j] == 1)
				M[i][j].setBackground(Color.BLACK);
			else if(mat[i][j] == 2)
				M[i][j].setBackground(Color.GRAY);
			else if(mat[i][j] == 3)
				M[i][j].setBackground(Color.BLUE);
			else if(mat[i][j] == 4)
				M[i][j].setBackground(Color.ORANGE);
			else if(mat[i][j] == 5)
				M[i][j].setBackground(Color.RED);
			else if(mat[i][j] == 6)
				M[i][j].setBackground(Color.GREEN);
			else if(mat[i][j] == 7)
				M[i][j].setBackground(Color.YELLOW);
			else if(mat[i][j] == 8)
				M[i][j].setBackground(Color.PINK);
			
			break;
		}	

		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		int i,j;
		for(i=0; i<r; i++)
			for(j=0; j<c; j++)
				
		if(e.getSource() == M[i][j])
		{
			M[i][j].setEnabled(false);
			
			if(turno == 1)
			{
				I = i;
				J = j;
				turno = 2;
			}
			else if(turno == 2)
			{
				if(mat[i][j] != mat[I][J])
				{
					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException a)
					{
						
					}
					M[i][j].setBackground(Color.WHITE);
					M[I][J].setBackground(Color.WHITE);
					M[i][j].setEnabled(true);
					M[I][J].setEnabled(true);
				}
				turno = 1;
			}
			break;
		}	
		
	}

}