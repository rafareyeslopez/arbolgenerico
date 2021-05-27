package es.ubu.inf.edat.pr05;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArbolGenerico<E> extends AbstractSet<E> {

	private Node<E> raiz;

	public ArbolGenerico() {
		super();
	}

	/**
	 *
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(E padre, E hijo) {
		if (padre == null) {
			raiz = new Node<>(hijo);
		} else {

			raiz.addChild(new Node<>(hijo));
		}

	}

	/**
	 * @return
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param string
	 * @return
	 */
	public List<E> descendants(E padre) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param string
	 */
	public void remove(String string) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	public List<E> breathFirstTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	public List<E> preOrderTraverse() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param string
	 * @return
	 */
	public int height(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	class Node<T> {

		private T data = null;

		private List<Node<T>> children = new ArrayList<>();

		private Node<T> parent = null;

		public Node(T data) {
			this.data = data;
		}

		public Node<T> addChild(Node<T> child) {
			child.setParent(this);
			this.children.add(child);
			return child;
		}

		public void addChildren(List<Node<T>> children) {
			children.forEach(each -> each.setParent(this));
			this.children.addAll(children);
		}

		public List<Node<T>> getChildren() {
			return children;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		private void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public Node<T> getParent() {
			return parent;
		}

	}
}
