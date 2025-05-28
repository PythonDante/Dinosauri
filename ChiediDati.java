import java.io.*;



class ChiediDati // HA IL COMPITO DI LEGGERE DATI DI DIVERSO TIPO FORNITI DAGLI UTENTI
{



 public final static int INTERO_IMPOSSIBILE = -1111111111;
 public final static double REALE_IMPOSSIBILE = -1.1111111111;
 public final static String STRINGA_IMPOSSIBILE = "qwertyuiopè+asdfghjklòàùzxcvbnm,.-";
 public final static String ANNIDAMENTO = "   ";
 public final static String SEPARATORE = ("_____________________________________________________________________________");
 public final static char ZERO = '0';
 public final static char UNO = '1';
 public final static char TERMINATORE = '*';



 public static String ChiediStringa(String s) // chiede una stringa, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   boolean uscita = false;
   String stringa = STRINGA_IMPOSSIBILE;
   String prompt = "\n" + s + ": ";


   while (uscita == false) // LOOP RIDONDANTE: INSERITO PER UNIFORMITA' CON GLI ALTRI METODI
      {
       System.out.print(prompt);
       // System.out.println("\nInserisci una stringa");
       // System.out.print("Stringa: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           stringa = StringaLetta;
           if (stringa.length() > 0)
              {
               uscita = true;
              }
          }
       catch(Exception e)
          {
           System.out.println("\nLettura stringa non corretta! Ripetere l'inserimento.\n");
          }
      }

   return stringa;
  }



 public static int ChiediIntero(String s) // chiede un numero intero qualsiasi, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   int intero = INTERO_IMPOSSIBILE;
   boolean uscita = false;
   String prompt = "\n" + s + ": ";

   while (uscita == false)
      {
       System.out.print(prompt);
       // System.out.println("\nInserisci un numero intero");
       // System.out.print("Valore: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           intero = Integer.valueOf(StringaLetta).intValue();
           uscita = true;
          }
       catch(Exception e)
          {
           System.out.println("\nIntero non corretto! Ripetere l'inserimento.\n");
          }
      }

   return intero;
  }



 public static int ChiediIntero(String s, int minimo, int massimo) // chiede un numero intero compreso fra minimo e massimo, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   int intero = INTERO_IMPOSSIBILE;
   boolean uscita = false;
   String prompt = "\n" + s + " compreso tra " + minimo + " e " + massimo + ": ";

   while (uscita == false)
      {
       System.out.print(prompt);
       // System.out.println("\nInserisci un numero intero compreso tra " + minimo + " e " + massimo);
       // System.out.print("Valore: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           intero = Integer.valueOf(StringaLetta).intValue();
           if ((intero >= minimo) && (intero <= massimo))
              {
               uscita = true;
              }
           else
              {
               System.out.println("\nIntero fuori dall'intervallo richiesto! Ripetere inserimento.\n");
              }
          }
       catch(Exception e)
          {
           System.out.println("\nIntero non corretto! Ripetere l'inserimento.\n");
          }
      }

   return intero;
  }



 public static double ChiediReale(String s) // chiede un numero reale qualsiasi, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   double reale = REALE_IMPOSSIBILE;
   boolean uscita = false;
   String prompt = "\n" + s + ": ";

   while (uscita == false)
      {
       System.out.print(prompt);
       // System.out.print("\nInserisci un numero reale");
       // System.out.print("Valore: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           reale = Double.valueOf(StringaLetta).doubleValue();
           uscita = true;
          }
       catch(Exception e)
          {
           System.out.println("\nReale non corretto! Ripetere l'inserimento.\n");
          }
      }

   return reale;
  }



 public static double ChiediReale(String s, double minimo, double massimo) // chiede un numero reale compreso fra minimo e massimo, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   double reale = REALE_IMPOSSIBILE;
   boolean uscita = false;
   String prompt = "\n" + s + " compreso tra " + minimo + " e " + massimo + ": ";

   while (uscita == false)
      {
       System.out.print(prompt);
       // System.out.println("\nInserisci un numero reale compreso tra " + minimo + " e " + massimo);
       // System.out.print("Valore: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           reale = Double.valueOf(StringaLetta).doubleValue();
           if ((reale >= minimo) && (reale <= massimo))
              {
               uscita = true;
              }
           else
              {
               System.out.println("\nReale fuori dall'intervallo richiesto! Ripetere inserimento.\n");
              }
          }
       catch(Exception e)
          {
           System.out.println("\nReale non corretto! Ripetere l'inserimento.\n");
          }
      }

   return reale;
  }



 public static double ChiediReale(String s, double minimo, double massimo, char terminatore) // chiede un numero di tipo double compreso fra minimo e massimo, oppure un carattere terminatore di fine serie, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   // InputStreamReader input = new InputStreamReader(System.in);
   // BufferedReader tastiera = new BufferedReader(input);

   double reale = -1;
   boolean uscita = false;
   String stringa;
   String prompt = s + " compreso tra " + minimo + " e " + massimo + " oppure il carattere terminatore di fine serie " + TERMINATORE + " (da utilizzare ESCLUSIVAMENTE per la terminazione degli inserimenti)";

   while (uscita == false)
      {
       // System.out.print("\n" + s + "compreso tra " + minimo + " e " + massimo + " oppure il carattere terminatore di fine serie " + TERMINATORE + " (da utilizzare ESCLUSIVAMENTE per la terminazione degli inserimenti)" + ": ");
       // System.out.println("\nInserisci un numero reale compreso tra " + minimo + " e " + massimo + " oppure il carattere terminatore di fine serie: " + TERMINATORE + " (da utilizzare ESCLUSIVAMENTE per la terminazione degli inserimenti)");
       // System.out.print("Numero o terminatore: ");
       stringa = ChiediStringa(prompt);
       if ((stringa.length() == 1) && (stringa.charAt(0) == TERMINATORE)) // è stato inserito il carattere di fine serie
          {
           reale = REALE_IMPOSSIBILE;
           uscita = true;
          }
       else // è stata inserita una stringa, bisogna verificare che sia un numero reale compreso tra minimo e massimo
          {
           try
              {
               reale = Double.valueOf(stringa).doubleValue();
               if ((reale >= minimo) && (reale <= massimo)) // è stato inserito un numero reale compreso fra minimo e massimmo
                  {
                   uscita = true;
                  }
               else
                  {
                   System.out.println("\nValore non compreso nell'intervallo da " + minimo + " a " + massimo + "! Ripetere inserimento.\n");
                  }
              }
           catch(Exception e)
              {
               System.out.println("\nNumero non corretto! Ripetere l'inserimento.\n");
              }
          }
      }

   return reale;
  }



 public static boolean Binaria(String s) // controlla se la stringa in ingresso rappresenta un numero binario
  {
   // impostazione dello standard input
   // InputStreamReader input = new InputStreamReader(System.in);
   // BufferedReader tastiera = new BufferedReader(input);

   boolean binaria = true;

   if (s.length() > 0) // la stringa non è nulla
      {
       for (int i = 0; i < s.length(); i++) // controlla che tutti i caratteri rappresentino cifre binarie
          {
           if ((s.charAt(i) != ZERO) && (s.charAt(i) != UNO))
              {
               binaria = false;
               break;
              }
          }
      }
   else // la stringa è nulla
      {
       binaria = false;
      }

   return binaria;
  }



 public static String ChiediBinario(String s) // chiede un numero binario di lunghezza arbitraria, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   // InputStreamReader input = new InputStreamReader(System.in);
   // BufferedReader tastiera = new BufferedReader(input);

   boolean uscita = false;
   String stringa = STRINGA_IMPOSSIBILE;
   String prompt = s;

   while (uscita == false)
      {
       // System.out.println("\nInserisci un numero binario");
       // System.out.print("Numero binario: ");
       stringa = ChiediStringa(s);
       if (Binaria(stringa))
          {
           uscita = true;
          }
       else
          {
           System.out.println("\nStringa non binaria! Ripetere l'inserimento.\n");
          }
      }

   return stringa;
  }



 public static String ChiediBinario(String s, int lunghezza) // chiede un numero binario di lunghezza predefinita, utilizzando la stringa passata come prompt
  {
   // impostazione dello standard input
   // InputStreamReader input = new InputStreamReader(System.in);
   /// BufferedReader tastiera = new BufferedReader(input);

   boolean uscita = false;
   String stringa = STRINGA_IMPOSSIBILE;
   String prompt = s + " di lunghezza " + lunghezza;

   while (uscita == false)
      {
       // System.out.println("\nInserisci un numero binario di lunghezza: " + lunghezza);
       // System.out.print("Numero binario di lunghezza " + lunghezza + " : ");
       stringa = ChiediStringa(prompt);
       if (Binaria(stringa))
          {
           if (stringa.length() == lunghezza) // la stringa è binaria ed è di lunghezza richiesta
              {
               uscita = true;
              }
           else // la stringa è binaria ma di lunghezza errata
              {
               System.out.println("\nNumero binario di lunghezza diversa da " + lunghezza + "! Ripetere l'inserimento.\n");
              }
          }
       else // la stringa non è binaria
          {
           System.out.println("\nStringa non binaria! Ripetere l'inserimento.\n");
          }
      }

   return stringa;
  }



 // DEPRECATED
 public static double ChiediVoto() // chiede un voto di tipo double compreso fra 0 e 10
  {
   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   double voto = -1;
   boolean uscita = false;

   while (uscita == false)
      {
       System.out.println("\nInserisci un voto compreso tra zero (da utilizzare ESCLUSIVAMENTE per la terminazione degli inserimenti) e 10");
       System.out.print("Voto: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           voto = Double.valueOf(StringaLetta).doubleValue();
           if ((voto >= 0.0) && (voto <=10.0))
              {
               uscita = true;
              }
           else
              {
               System.out.println("\nVoto non corretto! Ripetere inserimento.\n");
              }
          }
       catch(Exception e)
          {
           System.out.println("\nNumero non corretto! Ripetere l'inserimento.\n");
          }
      }

   return voto;
  }



 // DEPRECATED
 public static double ChiediPeso() // chiede un peso di tipo double compreso fra 0 e 1
  {
   double peso = -1;
   boolean uscita = false;

   // impostazione dello standard input
   InputStreamReader input = new InputStreamReader(System.in);
   BufferedReader tastiera = new BufferedReader(input);

   while (uscita == false)
      {
       System.out.println("\nInserisci un peso compreso tra 0 e 1");
       System.out.print("Peso: ");
       try
          {
           String StringaLetta = tastiera.readLine();
           peso = Double.valueOf(StringaLetta).doubleValue();
           if ((peso >= 0.0) && (peso <=1.0))
              {
               uscita = true;
              }
           else
              {
               System.out.println("\nPeso non corretto! Ripetere inserimento.\n");
              }
          }
       catch(Exception e)
          {
           System.out.println("\nNumero non corretto! Ripetere l'inserimento.\n");
          }
      }

   return peso;
  }
 


}