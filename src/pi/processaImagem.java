/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author CLIENTE
 */
public final class processaImagem {
    
    private int cols;
    private int rows;
    private int max_value;
    private String tipo_arquivo;
    private int mat_imagem[][];
    
    public processaImagem(String filename) throws FileNotFoundException{
        
       carregaImagem(filename);
        
    }
    
    public void carregaImagem(String filename) throws FileNotFoundException{
        //Lendo arquivo
        Scanner infile = new Scanner(new FileReader(filename));
        //Pulando as duas primeiras linhas
        this.tipo_arquivo = infile.nextLine();

        String linha = infile.nextLine();
        
        //Verifica se está na linha com as dimensões
        while(!verificaDimensoes(linha)){
            linha = infile.nextLine();
        }
        //Salvando dimensões nas variáveis
        this.cols = Integer.parseInt(linha.split("\\s+")[0]);
	this.rows = Integer.parseInt(linha.split("\\s+")[1]);

        System.out.println(cols + " colunas e " + rows + " linhas");
        
        //Salva o maior valor existente no arquivo
        linha = infile.nextLine();
        this.max_value = Integer.parseInt(linha);
        
        
        String linha_dividida[];
        
        //Cria a matriz da imagem com as dimensões obtidas
        this.mat_imagem = new int[rows][cols];
        int cont = 0;
     
        linha = infile.nextLine();
        linha_dividida = linha.split("(\\s+)");
        int tam_linha = linha_dividida.length;
        
        //Preenche a matriz da imagem
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){              
                if(cont == tam_linha){
                    linha = infile.nextLine();
                    linha_dividida = linha.split("(\\s+)");
                    tam_linha = linha_dividida.length;
                    cont = 0;
                }else{
                    this.mat_imagem[i][j] = Integer.parseInt(linha_dividida[cont]);
                    cont++;
                }               
            }
        }  
    }
    
    //Função que verifica se a linha atual é a que contem as dimensões
    //Caso seu tamanho após o split seja 2, significa que está na linha que contém as duas dimensões
    private boolean verificaDimensoes(String linha){
        String linha_dividida[] = linha.split("\\s+");
        return linha_dividida.length == 2;
    }
    
}
