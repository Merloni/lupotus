
#Rakennekuvaus


Pelilaudassa on kiinni 100 ruutu-oliota. Ruudut ovat kaksiulotteisessa taulussa ja niill� kaikilla on x- ja y-koordinaatit. Jokainen ruutu tiet�� onko siihen ammuttu, onko siin� laiva ja jos on mik� laiva siin� on. 

Graafinen k�ytt�liittym� luodaan siten, ett� jokaista pelilaudan ruutua kohtaan luodaan JButton-nappi sek� tapahtumankuuntelija, joka tiet�� oman ruutunsa koordinaatit. Nappia painamalla muutetaan sen tiet�m�n ruudun tilaa ammutuksi ja mik�li ruudussa oli laivan osa, my�s laivan osa muutetaan ammutuksi. Mik�li ruudussa potentiaalisesti ollut laivan osa oli viimeinen ampumatta ollut, muuten my�s laivan tilaksi ammuttu.

Graafisessa k�ytt�liittym�ss� on valikkon�kym�, pelin�kym� sek� highscore-n�kym�. Valikkon�kym�st� p��st��n siirtym��n peli- ja highscore-n�kym��n kahden JButton-napin avulla. Nappeihin on liitetty tapahtumankuuntelija, jotka kutsuvat n�kyv�� muuttavia metodeita. 