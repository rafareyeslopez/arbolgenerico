package es.ubu.inf.edat.pr05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import es.ubu.inf.edat.pr05.ArbolGenerico;
import junit.framework.TestCase;

public class ArbolGenericoTest extends TestCase {

	protected ArbolGenerico<String> jerarquia;
	protected String[] colecciones = {"List","Queue","Set","ArrayList","LinkedList","Deque","TreeSet","HashSet"};
	protected String[] conjuntos = {"SortedSet","TreeSet","HashSet"};
	
	@Before
	public void setUp() throws Exception {
		jerarquia = new ArbolGenerico<String>();
	}

	@After
	public void tearDown() throws Exception {
		jerarquia.clear();
	}

	/**
	 * Comprueba la insercion en el Arbol (elementos individuales)
	 */
//	@Test
	public void testInsertar() {
		
		System.out.println("Test de inserci�n de elementos");
		
		assertTrue(jerarquia.add(null,"Collection"));
		assertTrue(jerarquia.add("Collection","List"));
		assertTrue(jerarquia.add("Collection","Queue"));
		assertTrue(jerarquia.add("Collection","Set"));
		assertTrue(jerarquia.add("List","ArrayList"));
		assertTrue(jerarquia.add("List","LinkedList"));
		assertTrue(jerarquia.add("Queue","Deque"));
		assertTrue(jerarquia.add("Set","SortedSet"));
		assertTrue(jerarquia.add("Set","HashSet"));
		assertTrue(jerarquia.add("SortedSet","TreeSet"));
		
		assertEquals(10,jerarquia.size());
	
		System.out.println("Fin del Test");
		
	}

	// Pruebas adicionales:	(1) insertar un elemento como hijo de un nodo no incluido
	// 						(2) insertar un elemento ya incluido con otro padre
	
	/**
	 * Comprueba el acceso a los descendientes de un determinado nodo
	 */
//	@Test
	public void testDescendientes() {
		
		System.out.println("Test de consulta de descendientes");
		
		List<String> desc;
		testInsertar();
		
		desc = jerarquia.descendants("Collection");
		assertEquals(9,desc.size());
		assertTrue(desc.containsAll(Arrays.asList(colecciones)));
		
		desc = jerarquia.descendants("Set");
		assertEquals(3,desc.size());
		assertTrue(desc.containsAll(Arrays.asList(conjuntos)));
		
		System.out.println("Fin del Test");
	}

	// Pruebas adicionales: (1) obtener descendientes de nodos hojas
	//						(2) obtener descendientes de elementos no contenidos
	
	/**
	 * 
	 */
//	@Test
	public void testBorrado() {
		
		System.out.println("Test de borrado de un elemento (nodo intermedio)");
		
		testInsertar();
		assertEquals(10,jerarquia.size());
		
		jerarquia.remove("SortedSet");
		assertEquals(9,jerarquia.size());
		
		List<String> desc = jerarquia.descendants("Set");
		assertEquals(2, desc.size());
		assertTrue(desc.containsAll(Arrays.asList("TreeSet","HashSet")));
		
		System.out.println("Fin del Test");
	}
	
	// Pruebas adicionales: (1) el borrado de la raiz
	//						(2) el borrado de una hoja
	
	/**
	 * 
	 */
//	@Test
	public void testRecorridoAnchura(){
		
		System.out.println("Test de recorrido en anchura");
		
		testInsertar();
		
		List<String> anchura = jerarquia.breathFirstTraverse();
		assertEquals(10, anchura.size());
		
		List<String> Nivel1 = Arrays.asList("Collection");
		List<String> Nivel2 = Arrays.asList("List","Queue","Set");
		List<String> Nivel3 = Arrays.asList("ArrayList","LinkedList","Deque","SortedSet","HashSet");
		List<String> Nivel4 = Arrays.asList("TreeSet");

		assertTrue( Nivel1.containsAll(anchura.subList(0, 1)) );
		assertTrue( Nivel2.containsAll(anchura.subList(1, 4)) );
		assertTrue( Nivel3.containsAll(anchura.subList(4, 9)) );
		assertTrue( Nivel4.containsAll(anchura.subList(9, 10)) );
	
		List<String> control = Arrays.asList("Collection",
				"List","Queue","Set",
				"ArrayList","LinkedList","Deque","SortedSet","HashSet",
				"TreeSet");

		assertEquals(control,anchura);
		
		System.out.println("Fin del Test");
		
	}
	
	// Pruebas adicionales: (1) recorrido de un arbol vacio

//	@Test
	public void testRecorridoPreOrder(){
		
		System.out.println("Test de recorrido en preOrden");
		
		testInsertar();
		
		List<String> profundidad = jerarquia.preOrderTraverse();
		assertEquals(10, profundidad.size());

		List<String> control = Arrays.asList("Collection",
				"List","ArrayList","LinkedList",
				"Queue","Deque",
				"Set","SortedSet","TreeSet",
				"HashSet");

		assertEquals(control,profundidad);
		
		System.out.println("Fin del Test");
		
	}
	
	// Pruebas adicionales: (1) recorrido de un arbol vacio	
	
//	@Test
	public void testIterador(){
		
		System.out.println("Test de iteraci�n sobre el arbol");
		
		testInsertar();
		
		List<String> control = Arrays.asList("Collection",
				"List","ArrayList","LinkedList",
				"Queue","Deque",
				"Set","SortedSet","TreeSet",
				"HashSet");
		
		Iterator<String> itControl = control.iterator();
		Iterator<String> itProbado = jerarquia.iterator();
		
		while(itControl.hasNext()){
			assertEquals(itControl.next(), itProbado.next());
		}
		
		System.out.println("Fin del Test");
		
	}

	// Pruebas adicionales: (1) recorrido de un arbol vacio	
	
//	@Test
	public void testAltura(){
		
		System.out.println("Test de consulta de altura sobre datos");
		
		testInsertar();
		
		String[] controlElem = {"Collection",
				"List","ArrayList","LinkedList",
				"Queue","Deque",
				"Set","SortedSet","TreeSet",
				"HashSet"};
		
		int[] controlAltura = {3,1,0,0,1,0,2,1,0,0};
		
		for(int i=0; i<controlElem.length; i++){
			int altura = jerarquia.height(controlElem[i]);
			assertEquals(controlAltura[i], altura);
		}
		
		System.out.println("Fin del Test");
		
	}
	
	// Pruebas adicionales: (1) altura de un elemento no incluido
	
}
