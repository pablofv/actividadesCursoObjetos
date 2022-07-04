package ar.org.centro8.curso.java.proyecto.utils.file;

import java.util.List;

public class FileTextTest{
    public static void main(String[] args) {
        
        // String texto="";

        // StringBuilder sb=new StringBuilder();

        // for(int a=0;a<=300000;a++){
        //     texto+="x";
        //     //sb.append("x");
        // }

        String file="texto.txt";
        I_File fText=new FileText(file);
        fText.setText("Curso de java.\n");
        fText.appendText("Centro 8\n");
        fText.addLine("Primavera");
        fText.addLine("Verano");
        fText.addLine("Otoño");
        fText.addLine("Invierno");
        fText.addLines(List.of("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo", "Lunes", "Martes"));

        //System.out.println(fText.getText());
        //fText.print();

        //fText.getAll().forEach(System.out::println);
        System.out.println("Filtro");
        fText.getLikeFilter("ma").forEach(System.out::println);

        System.out.println("\n\nOrdenado");
        fText.getSortedLines().forEach(System.out::println);
        System.out.println("\n\nOrdenado inverso");
        fText.getReversedSortedLines().forEach(System.out::println);
        System.out.println("\n\nSin repetidos");
        fText.getLinkedHashSet().forEach(System.out::println);

        fText.remove("Viernes");

    }
}