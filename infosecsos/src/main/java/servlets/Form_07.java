package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

/**
 * Servlet implementation class Formulario7
 */
@WebServlet("/Form_07")
public class Form_07 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<String> resposta = new ArrayList<>();
        Integer numero = null;
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        Principal principal = new Principal();
        ArrayList<ListaOrdenada> list = new ArrayList<ListaOrdenada>();
        
        try {
            resposta = principal.Algoritmo();
            List<String> resposta1 = principal.transformarInstancia(resposta);
            for (int i = 0; i < resposta1.size(); i++) {
                list.add(new ListaOrdenada(resposta1.get(i)));
            }
            numero = principal.AlgoritmoInteger();

        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        
        final PrintWriter out = response.getWriter();
        
        // Início do HTML com design moderno
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>InfoSecSoS Ontology - Algorithm Solutions</title>");
        
        // Bootstrap e Fonts
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css'>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap' rel='stylesheet'>");
        
        // CSS Customizado
        out.println("<style>");
        out.println(":root {");
        out.println("    --primary-color: #14b8a6;");
        out.println("    --primary-dark: #0d9488;");
        out.println("    --secondary-color: #2dd4bf;");
        out.println("    --success-color: #10b981;");
        out.println("    --warning-color: #f59e0b;");
        out.println("    --danger-color: #ef4444;");
        out.println("    --dark-bg: #f8fafc;");
        out.println("    --card-bg: #ffffff;");
        out.println("    --text-primary: #1e293b;");
        out.println("    --text-secondary: #64748b;");
        out.println("    --border-color: #e2e8f0;");
        out.println("}");
        out.println("");
        out.println("* {");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("    box-sizing: border-box;");
        out.println("}");
        out.println("");
        out.println("body {");
        out.println("    font-family: 'Inter', sans-serif;");
        out.println("    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
        out.println("    min-height: 100vh;");
        out.println("    padding: 20px;");
        out.println("    position: relative;");
        out.println("}");
        out.println("");
        out.println("body::before {");
        out.println("    content: '';");
        out.println("    position: fixed;");
        out.println("    top: 0;");
        out.println("    left: 0;");
        out.println("    right: 0;");
        out.println("    bottom: 0;");
        out.println("    background: url('data:image/svg+xml,<svg xmlns=\\\"http://www.w3.org/2000/svg\\\" viewBox=\\\"0 0 100 100\\\" opacity=\\\"0.1\\\"><path d=\\\"M0 0 L100 100 M100 0 L0 100\\\" stroke=\\\"white\\\" stroke-width=\\\"0.5\\\"/></svg>');");
        out.println("    pointer-events: none;");
        out.println("}");
        out.println("");
        out.println(".main-container {");
        out.println("    max-width: 1000px;");
        out.println("    margin: 0 auto;");
        out.println("    position: relative;");
        out.println("    z-index: 1;");
        out.println("}");
        out.println("");
        out.println(".result-card {");
        out.println("    background: var(--card-bg);");
        out.println("    border-radius: 24px;");
        out.println("    box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25);");
        out.println("    overflow: hidden;");
        out.println("    border: 1px solid rgba(255, 255, 255, 0.2);");
        out.println("    margin-bottom: 20px;");
        out.println("}");
        out.println("");
        out.println(".card-header {");
        out.println("    background: linear-gradient(135deg, #14b8a6, #2dd4bf);");
        out.println("    padding: 40px 30px;");
        out.println("    text-align: center;");
        out.println("    border-bottom: none;");
        out.println("    position: relative;");
        out.println("    overflow: hidden;");
        out.println("}");
        out.println("");
        out.println(".card-header::before {");
        out.println("    content: '';");
        out.println("    position: absolute;");
        out.println("    top: -50%;");
        out.println("    right: -50%;");
        out.println("    width: 200%;");
        out.println("    height: 200%;");
        out.println("    background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%);");
        out.println("    animation: rotate 20s linear infinite;");
        out.println("}");
        out.println("");
        out.println("@keyframes rotate {");
        out.println("    from { transform: rotate(0deg); }");
        out.println("    to { transform: rotate(360deg); }");
        out.println("}");
        out.println("");
        out.println(".card-header h1 {");
        out.println("    color: white;");
        out.println("    font-weight: 700;");
        out.println("    font-size: 2.2rem;");
        out.println("    margin: 0;");
        out.println("    letter-spacing: -0.5px;");
        out.println("    text-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
        out.println("    position: relative;");
        out.println("    z-index: 1;");
        out.println("}");
        out.println("");
        out.println(".card-header .subtitle {");
        out.println("    color: rgba(255, 255, 255, 0.9);");
        out.println("    margin-top: 10px;");
        out.println("    font-size: 1rem;");
        out.println("    font-weight: 400;");
        out.println("    position: relative;");
        out.println("    z-index: 1;");
        out.println("}");
        out.println("");
        out.println(".content {");
        out.println("    padding: 40px;");
        out.println("}");
        out.println("");
        out.println(".stats-grid {");
        out.println("    display: grid;");
        out.println("    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));");
        out.println("    gap: 20px;");
        out.println("    margin-bottom: 30px;");
        out.println("}");
        out.println("");
        out.println(".stat-card {");
        out.println("    background: linear-gradient(135deg, #14b8a6, #2dd4bf);");
        out.println("    border-radius: 20px;");
        out.println("    padding: 25px;");
        out.println("    color: white;");
        out.println("    text-align: center;");
        out.println("    box-shadow: 0 10px 30px -5px rgba(20, 184, 166, 0.4);");
        out.println("    transition: transform 0.3s ease;");
        out.println("}");
        out.println("");
        out.println(".stat-card:hover {");
        out.println("    transform: translateY(-5px);");
        out.println("}");
        out.println("");
        out.println(".stat-icon {");
        out.println("    font-size: 2.5rem;");
        out.println("    margin-bottom: 15px;");
        out.println("}");
        out.println("");
        out.println(".stat-number {");
        out.println("    font-size: 3rem;");
        out.println("    font-weight: 700;");
        out.println("    line-height: 1;");
        out.println("    margin-bottom: 5px;");
        out.println("}");
        out.println("");
        out.println(".stat-label {");
        out.println("    font-size: 0.9rem;");
        out.println("    opacity: 0.9;");
        out.println("    text-transform: uppercase;");
        out.println("    letter-spacing: 1px;");
        out.println("}");
        out.println("");
        out.println(".section-title {");
        out.println("    color: var(--text-primary);");
        out.println("    font-weight: 600;");
        out.println("    font-size: 1.3rem;");
        out.println("    margin: 30px 0 20px 0;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    gap: 10px;");
        out.println("}");
        out.println("");
        out.println(".section-title i {");
        out.println("    color: #14b8a6;");
        out.println("    font-size: 1.5rem;");
        out.println("}");
        out.println("");
        out.println(".list-container {");
        out.println("    background: var(--dark-bg);");
        out.println("    border-radius: 20px;");
        out.println("    padding: 25px;");
        out.println("    border: 1px solid var(--border-color);");
        out.println("    margin-bottom: 30px;");
        out.println("    box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);");
        out.println("}");
        out.println("");
        out.println(".list-item {");
        out.println("    background: white;");
        out.println("    border-radius: 16px;");
        out.println("    padding: 18px 20px;");
        out.println("    margin-bottom: 12px;");
        out.println("    border: 1px solid var(--border-color);");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    gap: 15px;");
        out.println("    transition: all 0.3s ease;");
        out.println("    animation: slideIn 0.3s ease forwards;");
        out.println("    opacity: 0;");
        out.println("    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);");
        out.println("}");
        out.println("");
        out.println(".list-item:last-child {");
        out.println("    margin-bottom: 0;");
        out.println("}");
        out.println("");
        out.println(".list-item:hover {");
        out.println("    transform: translateX(8px);");
        out.println("    border-color: #14b8a6;");
        out.println("    box-shadow: 0 10px 20px -5px rgba(20, 184, 166, 0.2);");
        out.println("}");
        out.println("");
        out.println(".item-badge {");
        out.println("    width: 40px;");
        out.println("    height: 40px;");
        out.println("    background: linear-gradient(135deg, #14b8a6, #2dd4bf);");
        out.println("    color: white;");
        out.println("    border-radius: 40px;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    font-weight: 600;");
        out.println("    font-size: 1rem;");
        out.println("    flex-shrink: 0;");
        out.println("    box-shadow: 0 4px 10px rgba(20, 184, 166, 0.3);");
        out.println("}");
        out.println("");
        out.println(".item-content {");
        out.println("    flex-grow: 1;");
        out.println("}");
        out.println("");
        out.println(".item-title {");
        out.println("    color: var(--text-primary);");
        out.println("    font-weight: 600;");
        out.println("    font-size: 1.1rem;");
        out.println("    margin-bottom: 4px;");
        out.println("}");
        out.println("");
        out.println(".item-subtitle {");
        out.println("    color: var(--text-secondary);");
        out.println("    font-size: 0.85rem;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    gap: 5px;");
        out.println("}");
        out.println("");
        out.println(".item-icon {");
        out.println("    color: #14b8a6;");
        out.println("    font-size: 1.3rem;");
        out.println("    opacity: 0;");
        out.println("    transition: all 0.3s ease;");
        out.println("    flex-shrink: 0;");
        out.println("}");
        out.println("");
        out.println(".list-item:hover .item-icon {");
        out.println("    opacity: 1;");
        out.println("    transform: translateX(5px);");
        out.println("}");
        out.println("");
        out.println(".info-message {");
        out.println("    background: #ccfbf1;");
        out.println("    color: #115e59;");
        out.println("    padding: 16px 20px;");
        out.println("    border-radius: 16px;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    gap: 12px;");
        out.println("    margin-bottom: 25px;");
        out.println("    border-left: 4px solid #14b8a6;");
        out.println("}");
        out.println("");
        out.println(".info-message i {");
        out.println("    font-size: 1.5rem;");
        out.println("    color: #14b8a6;");
        out.println("}");
        out.println("");
        out.println(".action-buttons {");
        out.println("    display: flex;");
        out.println("    gap: 15px;");
        out.println("    justify-content: center;");
        out.println("    margin: 35px 0 20px;");
        out.println("    flex-wrap: wrap;");
        out.println("}");
        out.println("");
        out.println(".btn-primary {");
        out.println("    background: linear-gradient(135deg, #14b8a6, #2dd4bf);");
        out.println("    color: white;");
        out.println("    border: none;");
        out.println("    padding: 14px 30px;");
        out.println("    border-radius: 50px;");
        out.println("    font-weight: 500;");
        out.println("    font-size: 1rem;");
        out.println("    display: inline-flex;");
        out.println("    align-items: center;");
        out.println("    gap: 10px;");
        out.println("    transition: all 0.3s ease;");
        out.println("    cursor: pointer;");
        out.println("    box-shadow: 0 10px 20px -5px rgba(20, 184, 166, 0.4);");
        out.println("    border: none;");
        out.println("}");
        out.println("");
        out.println(".btn-primary:hover {");
        out.println("    transform: translateY(-3px);");
        out.println("    box-shadow: 0 20px 25px -5px rgba(20, 184, 166, 0.5);");
        out.println("    color: white;");
        out.println("}");
        out.println("");
        out.println(".btn-secondary {");
        out.println("    background: white;");
        out.println("    color: #14b8a6;");
        out.println("    border: 2px solid #14b8a6;");
        out.println("    padding: 12px 28px;");
        out.println("    border-radius: 50px;");
        out.println("    font-weight: 500;");
        out.println("    font-size: 1rem;");
        out.println("    display: inline-flex;");
        out.println("    align-items: center;");
        out.println("    gap: 10px;");
        out.println("    transition: all 0.3s ease;");
        out.println("    cursor: pointer;");
        out.println("    text-decoration: none;");
        out.println("}");
        out.println("");
        out.println(".btn-secondary:hover {");
        out.println("    background: #14b8a6;");
        out.println("    color: white;");
        out.println("    transform: translateY(-3px);");
        out.println("    box-shadow: 0 10px 20px -5px rgba(20, 184, 166, 0.3);");
        out.println("}");
        out.println("");
        out.println(".btn-outline {");
        out.println("    background: transparent;");
        out.println("    color: var(--text-secondary);");
        out.println("    border: 2px solid var(--border-color);");
        out.println("    padding: 12px 28px;");
        out.println("    border-radius: 50px;");
        out.println("    font-weight: 500;");
        out.println("    font-size: 1rem;");
        out.println("    display: inline-flex;");
        out.println("    align-items: center;");
        out.println("    gap: 10px;");
        out.println("    transition: all 0.3s ease;");
        out.println("    cursor: pointer;");
        out.println("}");
        out.println("");
        out.println(".btn-outline:hover {");
        out.println("    background: var(--dark-bg);");
        out.println("    color: var(--text-primary);");
        out.println("    border-color: var(--text-secondary);");
        out.println("}");
        out.println("");
        out.println(".timestamp {");
        out.println("    text-align: center;");
        out.println("    color: var(--text-secondary);");
        out.println("    font-size: 0.85rem;");
        out.println("    margin-top: 30px;");
        out.println("    padding-top: 20px;");
        out.println("    border-top: 1px solid var(--border-color);");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    gap: 8px;");
        out.println("}");
        out.println("");
        out.println("@keyframes slideIn {");
        out.println("    from {");
        out.println("        opacity: 0;");
        out.println("        transform: translateY(20px);");
        out.println("    }");
        out.println("    to {");
        out.println("        opacity: 1;");
        out.println("        transform: translateY(0);");
        out.println("    }");
        out.println("}");
        out.println("");
        out.println(".floating-icon {");
        out.println("    position: fixed;");
        out.println("    bottom: 30px;");
        out.println("    right: 30px;");
        out.println("    width: 60px;");
        out.println("    height: 60px;");
        out.println("    background: linear-gradient(135deg, #14b8a6, #2dd4bf);");
        out.println("    border-radius: 60px;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    color: white;");
        out.println("    font-size: 1.8rem;");
        out.println("    box-shadow: 0 15px 30px -5px rgba(20, 184, 166, 0.5);");
        out.println("    cursor: pointer;");
        out.println("    transition: all 0.3s ease;");
        out.println("    z-index: 1000;");
        out.println("    border: none;");
        out.println("}");
        out.println("");
        out.println(".floating-icon:hover {");
        out.println("    transform: scale(1.1) rotate(180deg);");
        out.println("    background: linear-gradient(135deg, #2dd4bf, #14b8a6);");
        out.println("    box-shadow: 0 20px 35px -5px rgba(20, 184, 166, 0.6);");
        out.println("}");
        out.println("");
        out.println(".badge-custom {");
        out.println("    background: rgba(20, 184, 166, 0.1);");
        out.println("    color: #14b8a6;");
        out.println("    padding: 4px 12px;");
        out.println("    border-radius: 50px;");
        out.println("    font-size: 0.75rem;");
        out.println("    font-weight: 600;");
        out.println("    display: inline-flex;");
        out.println("    align-items: center;");
        out.println("    gap: 4px;");
        out.println("}");
        out.println("");
        out.println("@media (max-width: 768px) {");
        out.println("    .card-header h1 {");
        out.println("        font-size: 1.6rem;");
        out.println("    }");
        out.println("    .content {");
        out.println("        padding: 20px;");
        out.println("    }");
        out.println("    .action-buttons {");
        out.println("        flex-direction: column;");
        out.println("    }");
        out.println("    .btn-primary, .btn-secondary, .btn-outline {");
        out.println("        width: 100%;");
        out.println("        justify-content: center;");
        out.println("    }");
        out.println("    .stats-grid {");
        out.println("        grid-template-columns: 1fr;");
        out.println("    }");
        out.println("    .floating-icon {");
        out.println("        width: 50px;");
        out.println("        height: 50px;");
        out.println("        font-size: 1.5rem;");
        out.println("        bottom: 20px;");
        out.println("        right: 20px;");
        out.println("    }");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        
        // Corpo do HTML
        out.println("<body oncontextmenu='return false'>");
        out.println("<div class='main-container'>");
        out.println("<div class='result-card'>");
        
        // Header
        out.println("<div class='card-header'>");
        out.println("<h1><i class='bi bi-shield-shaded me-2'></i>InfoSecSoS Ontology</h1>");
        out.println("<div class='subtitle'><i class='bi bi-cpu me-1'></i> Algorithm Solutions</div>");
        out.println("</div>");
        
        // Content
        out.println("<div class='content'>");
        
        // Stats Grid
        out.println("<div class='stats-grid'>");
        out.println("<div class='stat-card'>");
        out.println("<div class='stat-icon'><i class='bi bi-cpu'></i></div>");
        out.println("<div class='stat-number'>" + numero + "</div>");
        out.println("<div class='stat-label'>Algorithm Solutions</div>");
        out.println("</div>");
        
        out.println("<div class='stat-card' style=\"background: linear-gradient(135deg, #10b981, #34d399);\">");
        out.println("<div class='stat-icon'><i class='bi bi-list-check'></i></div>");
        out.println("<div class='stat-number'>" + list.size() + "</div>");
        out.println("<div class='stat-label'>Items Listed</div>");
        out.println("</div>");
        
        out.println("<div class='stat-card' style=\"background: linear-gradient(135deg, #f97316, #f59e0b);\">");
        out.println("<div class='stat-icon'><i class='bi bi-clock'></i></div>");
        out.println("<div class='stat-number'>" + new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date()) + "</div>");
        out.println("<div class='stat-label'>Time</div>");
        out.println("</div>");
        out.println("</div>");
        
        // Info Message
        out.println("<div class='info-message'>");
        out.println("<i class='bi bi-info-circle-fill'></i>");
        out.println("<div><strong>The amount of " + numero + " Algorithms!</strong> Complete list of algorithm solutions found in systems-of-systems.</div>");
        out.println("</div>");
        
        // Section Title
        out.println("<div class='section-title'>");
        out.println("<i class='bi bi-code-square'></i>");
        out.println("Algorithm Solutions Identified");
        out.println("<span class='badge-custom ms-2'><i class='bi bi-tag'></i> " + list.size() + " items</span>");
        out.println("</div>");
        
        // Lista de soluções de algoritmos
        out.println("<div class='list-container'>");
        
        if (list.isEmpty()) {
            out.println("<div style='text-align: center; padding: 40px; color: var(--text-secondary);'>");
            out.println("<i class='bi bi-emoji-frown' style='font-size: 3rem;'></i>");
            out.println("<p style='margin-top: 15px;'>No algorithm solution found</p>");
            out.println("</div>");
        } else {
            for (int i = 0; i < list.size(); i++) {
                String delay = String.format("%.1f", (i * 0.1));
                out.println("<div class='list-item' style='animation-delay: " + delay + "s'>");
                out.println("<div class='item-badge'>" + (i + 1) + "</div>");
                out.println("<div class='item-content'>");
                out.println("<div class='item-title'>" + list.get(i).getNome().toString() + "</div>");
                out.println("<div class='item-subtitle'>");
                out.println("<i class='bi bi-tag'></i> Algorithm");
                out.println("<span class='badge-custom ms-2'><i class='bi bi-cpu'></i> InfoSecSoS</span>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class='item-icon'><i class='bi bi-arrow-right-circle-fill'></i></div>");
                out.println("</div>");
            }
        }
        
        out.println("</div>");
        
        // Action Buttons
        out.println("<div class='action-buttons'>");
        out.println("<button onclick=\"window.location.href='" + request.getContextPath() + "/index.jsp'\" class='btn-primary'>");
        out.println("<i class='bi bi-house-door-fill'></i> Back to Home");
        out.println("</button>");
        
        // Botão "New Query" removido
        
        out.println("<button onclick='window.print()' class='btn-outline'>");
        out.println("<i class='bi bi-printer'></i> Print Result");
        out.println("</button>");
        out.println("</div>");
        
        // Timestamp
        out.println("<div class='timestamp'>");
        out.println("<i class='bi bi-clock-history'></i>");
        out.println("Result generated on " + new java.text.SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss").format(new java.util.Date()));
        out.println("</div>");
        
        out.println("</div>"); // Fecha content
        out.println("</div>"); // Fecha result-card
        out.println("</div>"); // Fecha main-container
        
        // Floating Action Button
        out.println("<button class='floating-icon' onclick='window.scrollTo({top: 0, behavior: \"smooth\"});'>");
        out.println("<i class='bi bi-arrow-up'></i>");
        out.println("</button>");
        
        // Scripts
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("<script>");
        out.println("document.addEventListener('DOMContentLoaded', function() {");
        out.println("    // Intersection Observer para animações");
        out.println("    const observer = new IntersectionObserver((entries) => {");
        out.println("        entries.forEach(entry => {");
        out.println("            if (entry.isIntersecting) {");
        out.println("                entry.target.style.opacity = '1';");
        out.println("                entry.target.style.transform = 'translateY(0)';");
        out.println("            }");
        out.println("        });");
        out.println("    }, { threshold: 0.1 });");
        out.println("");
        out.println("    document.querySelectorAll('.list-item, .stat-card').forEach(item => {");
        out.println("        item.style.opacity = '0';");
        out.println("        item.style.transform = 'translateY(20px)';");
        out.println("        item.style.transition = 'all 0.5s ease';");
        out.println("        observer.observe(item);");
        out.println("    });");
        out.println("");
        out.println("    // Loading effect nos botões");
        out.println("    document.querySelectorAll('button').forEach(btn => {");
        out.println("        btn.addEventListener('click', function(e) {");
        out.println("            if (this.classList.contains('btn-primary') || ");
        out.println("                this.classList.contains('btn-secondary') || ");
        out.println("                this.classList.contains('btn-outline')) {");
        out.println("                if (!this.classList.contains('no-loading') && ");
        out.println("                    !this.classList.contains('floating-icon')) {");
        out.println("                    const originalText = this.innerHTML;");
        out.println("                    this.innerHTML = '<span class=\"spinner-border spinner-border-sm me-2\" role=\"status\"></span> Loading...';");
        out.println("                    this.disabled = true;");
        out.println("                    setTimeout(() => {");
        out.println("                        this.innerHTML = originalText;");
        out.println("                        this.disabled = false;");
        out.println("                    }, 500);");
        out.println("                }");
        out.println("            }");
        out.println("        });");
        out.println("    });");
        out.println("});");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}