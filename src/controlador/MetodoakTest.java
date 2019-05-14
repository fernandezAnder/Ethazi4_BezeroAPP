package controlador;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class MetodoakTest {
	Metodoak metodos= new Metodoak();

		@Test
	
	public void konprobatuMD5() {
		String pasahitza="abracadabra";
		assertEquals(metodos.getMD5(pasahitza),("ec5287c45f0e70ec22d52e8bcbeeb640"));
	}
		
		@Test
		public void konprobatuNegatibo() {
			assertEquals(metodos.konprobatuNegatibo(2),(true));
		}
		@Test
		public void kanbioMetodoa() {
			assertEquals(metodos.kanbioMetodoa(388.88),metodos.kanbioMetodoa(388.88));
		}
		@Test
		public void konprobatuLetra() {
			
			assertEquals(metodos.konprobatuLetra("dsf"),(true));
		}
		@Test
		public void diruFalta() {
			double zbk=5;
			double prezioa=10;
			assertEquals(metodos.diruFalta(zbk, prezioa), false);
		}
		@Test
		public void balidatuSexua() {
			String sexua="G";
			
			assertEquals(metodos.balidatuSexua(sexua), true);
		}
		@Test
		public void kalkulatuLetra() {
			assertEquals(metodos.KalkulatuLetra(20233954), "A");
		}
}
