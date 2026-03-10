<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
    <title>InfoSecSoS Ontology</title>
    
    <!-- Bootstrap 5 e ícones modernos -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    
    <!-- Fontes modernas -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-dark: #4f46e5;
            --secondary-color: #8b5cf6;
            --success-color: #10b981;
            --dark-bg: #f8fafc;
            --card-bg: #ffffff;
            --text-primary: #1e293b;
            --text-secondary: #64748b;
            --border-color: #e2e8f0;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .main-container {
            max-width: 900px;
            margin: 0 auto;
        }

        .ontology-card {
            background: var(--card-bg);
            border-radius: 24px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
            overflow: hidden;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        .card-header {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            padding: 32px 24px;
            text-align: center;
            border-bottom: none;
        }

        .card-header h1 {
            color: white;
            font-weight: 600;
            font-size: 2rem;
            margin: 0;
            letter-spacing: -0.5px;
        }

        .progress-indicator {
            display: flex;
            justify-content: center;
            gap: 8px;
            padding: 24px;
            background: var(--dark-bg);
            border-bottom: 1px solid var(--border-color);
        }

        .step-badge {
            width: 40px;
            height: 40px;
            border-radius: 40px;
            background: white;
            border: 2px solid var(--border-color);
            display: flex;
            align-items: center;
            justify-content: center;
            color: var(--text-secondary);
            font-weight: 500;
            font-size: 1rem;
            transition: all 0.3s ease;
        }

        .step-badge.active {
            background: var(--primary-color);
            border-color: var(--primary-color);
            color: white;
            transform: scale(1.1);
            box-shadow: 0 4px 12px rgba(99, 102, 241, 0.3);
        }

        .step-badge.completed {
            background: var(--success-color);
            border-color: var(--success-color);
            color: white;
        }

        .questions-list {
            padding: 24px;
            background: white;
        }

        .question-item {
            background: var(--dark-bg);
            border-radius: 16px;
            padding: 20px;
            margin-bottom: 16px;
            border: 1px solid var(--border-color);
            transition: all 0.3s ease;
        }

        .question-item:last-child {
            margin-bottom: 0;
        }

        .question-item:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
            border-color: var(--primary-color);
        }

        .question-number {
            display: inline-block;
            background: var(--primary-color);
            color: white;
            font-size: 0.75rem;
            font-weight: 600;
            padding: 4px 10px;
            border-radius: 20px;
            margin-bottom: 8px;
            letter-spacing: 0.5px;
        }

        .question-text {
            color: var(--text-primary);
            font-weight: 500;
            font-size: 1rem;
            margin: 0 0 16px 0;
            line-height: 1.5;
        }

        .question-actions {
            display: flex;
            justify-content: flex-end;
        }

        .btn-modern {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 40px;
            font-weight: 500;
            font-size: 0.9rem;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            transition: all 0.3s ease;
            cursor: pointer;
            box-shadow: 0 4px 12px rgba(99, 102, 241, 0.3);
            text-decoration: none;
        }

        .btn-modern:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(99, 102, 241, 0.4);
            color: white;
        }

        .search-section {
            background: white;
            border-top: 1px solid var(--border-color);
            padding: 24px;
        }

        .search-title {
            color: var(--text-primary);
            font-weight: 600;
            font-size: 1.1rem;
            margin-bottom: 16px;
        }

        .search-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 16px;
            margin-bottom: 20px;
        }

        .search-card {
            background: var(--dark-bg);
            border-radius: 16px;
            padding: 20px;
            border: 1px solid var(--border-color);
        }

        .search-card h3 {
            color: var(--text-primary);
            font-size: 1rem;
            font-weight: 600;
            margin-bottom: 12px;
        }

        .modern-input {
            width: 100%;
            padding: 12px 16px;
            border: 2px solid var(--border-color);
            border-radius: 12px;
            font-family: 'Inter', sans-serif;
            font-size: 0.95rem;
            transition: all 0.3s ease;
            background: white;
            margin-bottom: 12px;
        }

        .modern-input:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 4px rgba(99, 102, 241, 0.1);
        }

        .tree-view-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border-radius: 16px;
            padding: 24px;
            color: white;
            text-align: center;
        }

        .floating-icon {
            position: fixed;
            bottom: 24px;
            right: 24px;
            width: 56px;
            height: 56px;
            background: var(--primary-color);
            border-radius: 56px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 1.5rem;
            box-shadow: 0 4px 16px rgba(99, 102, 241, 0.4);
            cursor: pointer;
            transition: all 0.3s ease;
            z-index: 1000;
        }

        .floating-icon:hover {
            transform: scale(1.1) rotate(90deg);
            background: var(--secondary-color);
        }

        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .question-item {
            animation: slideIn 0.3s ease forwards;
        }

        @media (max-width: 768px) {
            .card-header h1 {
                font-size: 1.5rem;
            }
            
            .search-grid {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body oncontextmenu='return false'>
    <div class="main-container">
        <div class="ontology-card">
            <!-- Header -->
            <div class="card-header">
                <h1><i class="bi bi-shield-shaded me-2"></i>InfoSecSoS Ontology</h1>
                <div class="subtitle">Sistema de Ontologia para Segurança da Informação em Sistemas-de-Sistemas</div>
            </div>

            <!-- Progress Indicator -->
            <div class="progress-indicator">
                <span class="step-badge active"><i class="bi bi-1-circle"></i></span>
                <span class="step-badge"><i class="bi bi-2-circle"></i></span>
                <span class="step-badge"><i class="bi bi-3-circle"></i></span>
                <span class="step-badge"><i class="bi bi-4-circle"></i></span>
                <span class="step-badge"><i class="bi bi-5-circle"></i></span>
            </div>

            <!-- Questions List -->
            <div class="questions-list">
                <!-- Questão 1 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 1</span>
                    <p class="question-text">How is information security divided into systems-of-systems in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_01" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 2 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 2</span>
                    <p class="question-text">What are the systems-of-systems information security technologies, models, techniques, tools or threat in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_02" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 3 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 3</span>
                    <p class="question-text">What are the specific factors of information security in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_03" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 4 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 4</span>
                    <p class="question-text">What are the types of information security human factors in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_04" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 5 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 5</span>
                    <p class="question-text">What are the information security assessment methods of systems-of-systems in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_05" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 6 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 6</span>
                    <p class="question-text">What encryption solutions are currently found in systems-of-systems in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_06" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 7 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 7</span>
                    <p class="question-text">What algorithm solutions are currently found in systems-of-systems in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_07" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Questão 8 -->
                <div class="question-item">
                    <span class="question-number">QUESTÃO 8</span>
                    <p class="question-text">What is the application domain of information security in systems-of-systems in InfoSecSoS?</p>
                    <div class="question-actions">
                        <form action="<%=request.getContextPath()%>/Form_10" method="get">
                            <button type="submit" class="btn-modern">
                                <i class="bi bi-arrow-right-circle"></i> Responder
                            </button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Search Section -->
            <div class="search-section">
                <div class="search-title">
                    <i class="bi bi-search me-2"></i>Ferramentas de Busca
                </div>
                <div class="search-grid">
                    <!-- Busca por Criptografia -->
                    <div class="search-card">
                        <h3><i class="bi bi-lock me-2"></i>Busca por Criptografia</h3>
                        <form action="<%=request.getContextPath()%>/Form_08" method="get">
                            <input type="text" class="modern-input" name="criptografia" placeholder="Ex: AES, RSA, DES...">
                            <button type="submit" class="btn-modern w-100">
                                <i class="bi bi-search"></i> Buscar
                            </button>
                        </form>
                    </div>

                    <!-- Busca por Algoritmo -->
                    <div class="search-card">
                        <h3><i class="bi bi-cpu me-2"></i>Busca por Algoritmo</h3>
                        <form action="<%=request.getContextPath()%>/Form_09" method="get">
                            <input type="text" class="modern-input" name="algoritmo" placeholder="Ex: SHA-256, MD5...">
                            <button type="submit" class="btn-modern w-100">
                                <i class="bi bi-search"></i> Buscar
                            </button>
                        </form>
                    </div>
                </div>

                <!-- Tree View -->
                <div class="tree-view-card">
                    <i class="bi bi-diagram-3 fs-1 mb-3"></i>
                    <h3 class="mb-3">Hierarchy Tree View</h3>
                    <p class="mb-4">Visualize a estrutura hierárquica completa da ontologia InfoSecSoS</p>
                    <form action="treeView.jsp" method="POST">
                        <button type="submit" class="btn-modern">
                            <i class="bi bi-graph-up"></i> Visualizar Árvore
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Floating Action Button -->
    <div class="floating-icon" onclick="window.scrollTo({top: 0, behavior: 'smooth'});">
        <i class="bi bi-arrow-up-short"></i>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Animação de entrada para os cards
        document.addEventListener('DOMContentLoaded', function() {
            const observer = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.style.opacity = '1';
                        entry.target.style.transform = 'translateY(0)';
                    }
                });
            });

            document.querySelectorAll('.question-item').forEach(item => {
                item.style.opacity = '0';
                item.style.transform = 'translateY(20px)';
                observer.observe(item);
            });

            // Atualizar indicadores de progresso baseado no scroll
            window.addEventListener('scroll', function() {
                let scrollPosition = window.scrollY;
                let windowHeight = window.innerHeight;
                let documentHeight = document.documentElement.scrollHeight;
                
                let progress = (scrollPosition / (documentHeight - windowHeight)) * 100;
                let activeStep = Math.floor(progress / 20) + 1;
                
                document.querySelectorAll('.step-badge').forEach((step, index) => {
                    step.classList.remove('active', 'completed');
                    if (index + 1 < activeStep) {
                        step.classList.add('completed');
                    } else if (index + 1 === activeStep) {
                        step.classList.add('active');
                    }
                });
            });
        });

        // Prevenir submissão acidental com Enter
        document.querySelectorAll('.modern-input').forEach(input => {
            input.addEventListener('keypress', function(e) {
                if (e.key === 'Enter') {
                    e.preventDefault();
                    this.closest('form').submit();
                }
            });
        });
    </script>
</body>
</html>