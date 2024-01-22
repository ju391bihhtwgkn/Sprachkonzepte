// Generator.java
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.ST;

import java.net.InterfaceAddress;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public final class Generator {

	public static void main(String[] args) throws Exception {
		var list = new LinkedList<ClassInfo>();
		list.add(new ClassInfo(Class.forName("java.lang.String")));
		list.add(new ClassInfo(Class.forName("java.util.Iterator")));
		list.add(new ClassInfo(Class.forName("java.time.Month")));
		

		ST templ = new STGroupFile(args[0]).getInstanceOf("aufgabe06");
		templ.add("list", list);
		String result = templ.render();
		System.out.println(result);
	
	}
}

final class ClassInfo {
	public final String name;
	public LinkedList<InterfaceInfo> interfaces;
	public boolean isInterface;

	public ClassInfo(Class<?> c) {
		this.name = c.getName();
		this.interfaces = new LinkedList<>();
		this.isInterface = false;

		if (c.isInterface()) {
			this.isInterface = true;
			var currentInterface = new InterfaceInfo(c.getName());
			for( var m : c.getMethods()) {
				var parameterTypes = Arrays.stream(m.getParameterTypes())
					.map(Class::getName)
					.collect(Collectors.joining(", "));
				currentInterface.methods.add(m.getReturnType().getName() + " " + m.getName() + "(" + parameterTypes + ")");
			}
			this.interfaces.add(currentInterface);
		} else {
		for(var i : c.getInterfaces()) {
			var currentInterface = new InterfaceInfo(i.getName());

			for(var j : i.getMethods()) {
				var parameterTypes = Arrays.stream(j.getParameterTypes())
											.map(Class::getName)
											.collect(Collectors.joining(", "));
				currentInterface.methods.add(j.getReturnType().getName() + " " + j.getName() + "(" + parameterTypes + ")");
			}

			this.interfaces.add(currentInterface);
		}
		}
	}
	

}


final class InterfaceInfo {

	public final String name;
	public final LinkedList<String> methods;

	public InterfaceInfo(String name) {
		this.name = name;
		this.methods = new LinkedList<>();
	}
}