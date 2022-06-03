package model;

import java.io.InputStream;



public class Receita {
    
    private int id;
    private String autor, titulo, ingredientes, modopreparo, data;
    private InputStream imagem;
    
    public Receita(){
        super();
    }
    
     public Receita(String autor){
       this.autor = autor;
       
    }
     
     public Receita(String autor,String data, String titulo, String ingredientes, String modopreparo){
        this.autor = autor;
        this.data = data;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modopreparo = modopreparo; 
    }
    
     public Receita(int id, String autor,String data, String titulo, String ingredientes, String modopreparo){
        this.autor = autor;
        this.data = data;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modopreparo = modopreparo; 
    }
     
     public Receita(String autor, String titulo, String ingredientes, String modopreparo, String data, InputStream imagem){
        this.autor = autor;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modopreparo = modopreparo;
        this.data = data;
        this.imagem = imagem;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getIngredientes(){
        return ingredientes;
    }
    
    public void setIngredientes(String ingredientes){
        this.ingredientes = ingredientes;
    }
    
    public String getModopreparo(){
        return modopreparo;
    }
    
    public void setModopreparo(String modopreparo){
        this.modopreparo = modopreparo;
    }
    
    public String getData(){
        return data;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public InputStream getImagem(){
        return imagem;
    }
    
    public void setImagem(InputStream imagem){
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", ingredientes=" + ingredientes + ", modopreparo=" + modopreparo + ", data=" + data + ", imagem=" + imagem + '}';
    }
    
    
}
