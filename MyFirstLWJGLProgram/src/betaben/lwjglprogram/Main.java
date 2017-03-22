package betaben.lwjglprogram;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.opengl.GL11.*;

public class Main {

	public float xMod = 0;
	public float yMod = 0;
	
	public float speed = 0.003f;
	
	public float color_red = 1;
	public float color_blue = 0;
	
	public Main(){
		if(!glfwInit()){
			System.err.print("Failed to initialize GLFW!");
			System.exit(1);
		}
		
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		
		long window = glfwCreateWindow(640, 480, "My First LWJGL Program", 0, 0);
		
		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width()-640)/2, (videoMode.height()-480)/2);
		
		glfwShowWindow(window);
		
		glfwMakeContextCurrent(window);
		
		GL.createCapabilities();
		
		glEnable(GL_TEXTURE_2D);
		
		Texture tex = new Texture("./res/texture.png");
		
		while(glfwWindowShouldClose(window) != true){
			if(glfwGetKey(window, GLFW_KEY_ESCAPE) == GL_TRUE){
				glfwSetWindowShouldClose(window, true);
			} 
			if(glfwGetKey(window, GLFW_KEY_W) == GL_TRUE){
				yMod+=speed;
			} 
			if(glfwGetKey(window, GLFW_KEY_A) == GL_TRUE){
				xMod-=speed;
			} 
			if(glfwGetKey(window, GLFW_KEY_S) == GL_TRUE){
				yMod-=speed;
			} 
			if(glfwGetKey(window, GLFW_KEY_D) == GL_TRUE){
				xMod+=speed;
			} 
			if(glfwGetMouseButton(window, 0) == GL_TRUE){
				color_red = 0.25f;
				color_blue = 1;
			} else {
				color_red = 1;
				color_blue = 0.25f;
			}
			
			glfwPollEvents();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			tex.bind();
			
			glBegin(GL_QUADS);
				
				glTexCoord2f(0, 0);
				glVertex2f(-0.5f, 0.5f);
				
				glTexCoord2f(1, 0);
				glVertex2f(0.5f, 0.5f);
				
				glTexCoord2f(1, 1);
				glVertex2f(0.5f, -0.5f);
				
				glTexCoord2f(0, 1);
				glVertex2f(-0.5f, -0.5f);
			
			glEnd();
			
			glfwSwapBuffers(window);
		}
		
		glfwTerminate();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void move(){
			//Middle Shape
			glColor4f(1,0,0,0);
			glVertex2f(-0.5f-yMod, 0.5f+yMod);
			glVertex2f(0.5f+yMod, 0.5f+yMod);
			glVertex2f(0.5f+yMod, -0.5f-yMod);
			glVertex2f(-0.5f-yMod, -0.5f-yMod);
				
			//Left Shape
			glColor4f(0,0,1,0);
			glVertex2f(-1, 1f);
			glVertex2f(-0.5f-yMod, 0.5f+yMod);
			glVertex2f(-0.5f-yMod, -0.5f-yMod);
			glVertex2f(-1f, -1f);
			
			//Top Shape
			glColor4f(0,0,.5f,0);
			glVertex2f(-1, 1);
			glVertex2f(1, 1);
			glVertex2f(0.5f+yMod, 0.5f+yMod);
			glVertex2f(-0.5f-yMod, 0.5f+yMod);
				
			//Right Shape
			glColor4f(0,0,1,0);
			glVertex2f(0.5f+yMod, 0.5f+yMod);
			glVertex2f(1, 1);
			glVertex2f(1, -1);
			glVertex2f(0.5f+yMod, -0.5f-yMod);
				
			//Bottom Shape
			glColor4f(0,0,.5f,0);
			glVertex2f(-0.5f-yMod, -0.5f-yMod);
			glVertex2f(0.5f+yMod, -0.5f-yMod);
			glVertex2f(1, -1);
			glVertex2f(-1, -1);
	}
	
	public void w(){
		//Middle Shape
		glColor4f(1,0,0,0);
		glVertex2f(-0.5f-yMod, 0.5f+yMod);
		glVertex2f(0.5f+yMod, 0.5f+yMod);
		glVertex2f(0.5f+yMod, -0.5f-yMod);
		glVertex2f(-0.5f-yMod, -0.5f-yMod);
		
		//Left Shape
		glColor4f(0,0,1,0);
		glVertex2f(-1, 1f);
		glVertex2f(-0.5f-yMod, 0.5f+yMod);
		glVertex2f(-0.5f-yMod, -0.5f-yMod);
		glVertex2f(-1f, -1f);
	
		//Top Shape
		glColor4f(0,0,.5f,0);
		glVertex2f(-1, 1);
		glVertex2f(1, 1);
		glVertex2f(0.5f+yMod, 0.5f+yMod);
		glVertex2f(-0.5f-yMod, 0.5f+yMod);
		
		//Right Shape
		glColor4f(0,0,1,0);
		glVertex2f(0.5f+yMod, 0.5f+yMod);
		glVertex2f(1, 1);
		glVertex2f(1, -1);
		glVertex2f(0.5f+yMod, -0.5f-yMod);
		
		//Bottom Shape
		glColor4f(0,0,.5f,0);
		glVertex2f(-0.5f-yMod, -0.5f-yMod);
		glVertex2f(0.5f+yMod, -0.5f-yMod);
		glVertex2f(1, -1);
		glVertex2f(-1, -1);
	}
	
	public void a(){
		//Middle Shape
		glColor4f(1,0,0,0);
		glVertex2f(-0.5f+xMod, 0.5f);
		glVertex2f(0.5f+xMod, 0.5f);
		glVertex2f(0.5f+xMod, -0.5f);
		glVertex2f(-0.5f+xMod, -0.5f);
		
		//Left Shape
		glColor4f(0,0,1,0);
		glVertex2f(-1, 1f);
		glVertex2f(-0.5f+xMod, 0.5f);
		glVertex2f(-0.5f+xMod, -0.5f);
		glVertex2f(-1f, -1f);
	
		//Top Shape
		glColor4f(0,0,.5f,0);
		glVertex2f(-1, 1);
		glVertex2f(1, 1);
		glVertex2f(0.5f+xMod, 0.5f);
		glVertex2f(-0.5f+xMod, 0.5f);
		
		//Right Shape
		glColor4f(0,0,1,0);
		glVertex2f(0.5f+xMod, 0.5f);
		glVertex2f(1, 1);
		glVertex2f(1, -1);
		glVertex2f(0.5f+xMod, -0.5f);
		
		//Bottom Shape
		glColor4f(0,0,.5f,0);
		glVertex2f(-0.5f+xMod, -0.5f);
		glVertex2f(0.5f+xMod, -0.5f);
		glVertex2f(1, -1);
		glVertex2f(-1, -1);
	}
	
	public void s(){
		
	}
	
	public void d(){
		
	}
}
