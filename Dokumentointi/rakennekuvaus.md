
#Rakennekuvaus


Pelilaudassa on kiinni 100 ruutu-oliota. Ruudut ovat kaksiulotteisessa taulussa ja niillä kaikilla on x- ja y-koordinaatit. Jokainen ruutu tietää onko siihen ammuttu, onko siinä laiva ja jos on mikä laiva siinä on. 

Graafinen käyttöliittymä luodaan siten, että jokaista pelilaudan ruutua kohtaan luodaan JButton-nappi sekä tapahtumankuuntelija, joka tietää oman ruutunsa koordinaatit. Nappia painamalla muutetaan sen tietämän ruudun tilaa ammutuksi ja mikäli ruudussa oli laivan osa, myös laivan osa muutetaan ammutuksi. Mikäli ruudussa potentiaalisesti ollut laivan osa oli viimeinen ampumatta ollut, muuten myös laivan tilaksi ammuttu.

Graafisessa käyttöliittymässä on valikkonäkymä, pelinäkymä sekä highscore-näkymä. Valikkonäkymästä päästään siirtymään peli- ja highscore-näkymään kahden JButton-napin avulla. Nappeihin on liitetty tapahtumankuuntelija, jotka kutsuvat näkyvää muuttavia metodeita. 