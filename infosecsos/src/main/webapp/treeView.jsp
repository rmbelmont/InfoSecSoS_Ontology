<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>InfoSecSoS Ontology - Tree View</title>
    
    <!-- Bootstrap e Fonts -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    
    <style>
        :root {
            --primary-color: #6366f1;
            --primary-dark: #4f46e5;
            --secondary-color: #8b5cf6;
            --success-color: #10b981;
            --warning-color: #f59e0b;
            --danger-color: #ef4444;
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
            position: relative;
        }

        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" opacity="0.1"><path d="M0 0 L100 100 M100 0 L0 100" stroke="white" stroke-width="0.5"/></svg>');
            pointer-events: none;
        }

        .main-container {
            max-width: 1200px;
            margin: 0 auto;
            position: relative;
            z-index: 1;
        }

        .tree-card {
            background: var(--card-bg);
            border-radius: 24px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25);
            overflow: hidden;
            border: 1px solid rgba(255, 255, 255, 0.2);
            margin-bottom: 20px;
        }

        .card-header {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            padding: 40px 30px;
            text-align: center;
            border-bottom: none;
            position: relative;
            overflow: hidden;
        }

        .card-header::before {
            content: '';
            position: absolute;
            top: -50%;
            right: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%);
            animation: rotate 20s linear infinite;
        }

        @keyframes rotate {
            from { transform: rotate(0deg); }
            to { transform: rotate(360deg); }
        }

        .card-header h1 {
            color: white;
            font-weight: 700;
            font-size: 2.2rem;
            margin: 0;
            letter-spacing: -0.5px;
            text-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            position: relative;
            z-index: 1;
        }

        .card-header .subtitle {
            color: rgba(255, 255, 255, 0.9);
            margin-top: 10px;
            font-size: 1rem;
            font-weight: 400;
            position: relative;
            z-index: 1;
        }

        .content {
            padding: 40px;
        }

        .tree-header {
            display: flex;
            align-items: center;
            gap: 15px;
            margin-bottom: 30px;
            padding: 20px;
            background: var(--dark-bg);
            border-radius: 16px;
            border: 1px solid var(--border-color);
        }

        .tree-icon {
            width: 60px;
            height: 60px;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            border-radius: 60px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 1.8rem;
            flex-shrink: 0;
        }

        .tree-info {
            flex-grow: 1;
        }

        .tree-title {
            color: var(--text-primary);
            font-weight: 600;
            font-size: 1.3rem;
            margin-bottom: 5px;
        }

        .tree-description {
            color: var(--text-secondary);
            font-size: 0.95rem;
            display: flex;
            align-items: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .tree-description span {
            display: flex;
            align-items: center;
            gap: 5px;
        }

        .tree-description i {
            color: var(--primary-color);
        }

        .image-container {
            background: linear-gradient(135deg, #f8fafc 0%, #e2e8f0 100%);
            border-radius: 20px;
            padding: 30px;
            border: 1px solid var(--border-color);
            margin-bottom: 30px;
            box-shadow: 0 10px 30px -10px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .image-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 20px 40px -10px rgba(0, 0, 0, 0.3);
        }

        .image-wrapper {
            text-align: center;
            background: white;
            border-radius: 16px;
            padding: 20px;
            border: 1px solid var(--border-color);
        }

        .image-wrapper img {
            max-width: 100%;
            height: auto;
            border-radius: 12px;
            box-shadow: 0 10px 20px -5px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease;
        }

        .image-wrapper img:hover {
            transform: scale(1.02);
        }

        .image-caption {
            margin-top: 15px;
            color: var(--text-secondary);
            font-size: 0.9rem;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }

        .image-caption i {
            color: var(--primary-color);
        }

        .action-buttons {
            display: flex;
            gap: 15px;
            justify-content: center;
            margin: 35px 0 20px;
            flex-wrap: wrap;
        }

        .btn-primary {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            color: white;
            border: none;
            padding: 14px 30px;
            border-radius: 50px;
            font-weight: 500;
            font-size: 1rem;
            display: inline-flex;
            align-items: center;
            gap: 10px;
            transition: all 0.3s ease;
            cursor: pointer;
            box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.4);
            border: none;
            text-decoration: none;
        }

        .btn-primary:hover {
            transform: translateY(-3px);
            box-shadow: 0 20px 25px -5px rgba(99, 102, 241, 0.5);
            color: white;
        }

        .btn-secondary {
            background: white;
            color: var(--primary-color);
            border: 2px solid var(--primary-color);
            padding: 12px 28px;
            border-radius: 50px;
            font-weight: 500;
            font-size: 1rem;
            display: inline-flex;
            align-items: center;
            gap: 10px;
            transition: all 0.3s ease;
            cursor: pointer;
            text-decoration: none;
        }

        .btn-secondary:hover {
            background: var(--primary-color);
            color: white;
            transform: translateY(-3px);
            box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.3);
        }

        .timestamp {
            text-align: center;
            color: var(--text-secondary);
            font-size: 0.85rem;
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid var(--border-color);
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }

        .floating-icon {
            position: fixed;
            bottom: 30px;
            right: 30px;
            width: 60px;
            height: 60px;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            border-radius: 60px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 1.8rem;
            box-shadow: 0 15px 30px -5px rgba(99, 102, 241, 0.5);
            cursor: pointer;
            transition: all 0.3s ease;
            z-index: 1000;
            border: none;
        }

        .floating-icon:hover {
            transform: scale(1.1) rotate(180deg);
            background: linear-gradient(135deg, var(--secondary-color), var(--primary-color));
            box-shadow: 0 20px 35px -5px rgba(99, 102, 241, 0.6);
        }

        .badge-custom {
            background: rgba(99, 102, 241, 0.1);
            color: var(--primary-color);
            padding: 4px 12px;
            border-radius: 50px;
            font-size: 0.75rem;
            font-weight: 600;
            display: inline-flex;
            align-items: center;
            gap: 4px;
        }

        @media (max-width: 768px) {
            .card-header h1 {
                font-size: 1.6rem;
            }
            
            .content {
                padding: 20px;
            }
            
            .action-buttons {
                flex-direction: column;
            }
            
            .btn-primary, .btn-secondary {
                width: 100%;
                justify-content: center;
            }
            
            .tree-header {
                flex-direction: column;
                text-align: center;
            }
            
            .tree-description {
                flex-direction: column;
                gap: 8px;
            }
            
            .floating-icon {
                width: 50px;
                height: 50px;
                font-size: 1.5rem;
                bottom: 20px;
                right: 20px;
            }
        }
    </style>
</head>
<body oncontextmenu='return false'>
    <div class="main-container">
        <div class="tree-card">
            <!-- Header -->
            <div class="card-header">
                <h1><i class="bi bi-diagram-3 me-2"></i>InfoSecSoS Ontology</h1>
                <div class="subtitle"><i class="bi bi-graph-up me-1"></i> Visualização Hierárquica</div>
            </div>

            <!-- Content -->
            <div class="content">
                <!-- Tree Header -->
                <div class="tree-header">
                    <div class="tree-icon">
                        <i class="bi bi-diagram-3"></i>
                    </div>
                    <div class="tree-info">
                        <div class="tree-title">
                            <i class="bi bi-tree-fill me-2"></i>Tree View - InfoSecSoS Ontology
                        </div>
                        <div class="tree-description">
                            <span><i class="bi bi-calendar"></i> <%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %></span>
                            <span><i class="bi bi-clock"></i> <%= new java.text.SimpleDateFormat("HH:mm").format(new java.util.Date()) %></span>
                            <span><i class="bi bi-tag"></i> Versão 1.0</span>
                        </div>
                    </div>
                </div>

                <!-- Image Container -->
                <div class="image-container">
                    <div class="image-wrapper">
                        <img src="imagens/02.png" alt="Tree View - InfoSecSoS Ontology" class="img-fluid">
                        <div class="image-caption">
                            <i class="bi bi-info-circle-fill"></i>
                            Estrutura hierárquica da ontologia InfoSecSoS
                        </div>
                    </div>
                </div>

                <!-- Action Buttons -->
                <div class="action-buttons">
                    <button onclick="window.location.href='<%= request.getContextPath() %>/index.jsp'" class="btn-primary">
                        <i class="bi bi-house-door-fill"></i> Voltar ao Início
                    </button>
                    
                    <button onclick="window.print()" class="btn-secondary">
                        <i class="bi bi-printer"></i> Imprimir Visualização
                    </button>
                    
                    <button onclick="window.location.reload()" class="btn-secondary">
                        <i class="bi bi-arrow-repeat"></i> Atualizar
                    </button>
                </div>

                <!-- Timestamp -->
                <div class="timestamp">
                    <i class="bi bi-clock-history"></i>
                    Visualização gerada em <%= new java.text.SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss").format(new java.util.Date()) %>
                </div>
            </div>
        </div>
    </div>

    <!-- Floating Action Button -->
    <button class="floating-icon" onclick="window.scrollTo({top: 0, behavior: 'smooth'});">
        <i class="bi bi-arrow-up"></i>
    </button>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // Animação de entrada
            const observer = new IntersectionObserver((entries) => {
                entries.forEach(entry => {
                    if (entry.isIntersecting) {
                        entry.target.style.opacity = '1';
                        entry.target.style.transform = 'translateY(0)';
                    }
                });
            }, { threshold: 0.1 });

            document.querySelectorAll('.image-container, .tree-header').forEach(item => {
                item.style.opacity = '0';
                item.style.transform = 'translateY(20px)';
                item.style.transition = 'all 0.5s ease';
                observer.observe(item);
            });

            // Adicionar efeito de zoom na imagem
            const image = document.querySelector('.image-wrapper img');
            if (image) {
                image.addEventListener('click', function() {
                    this.style.transform = 'scale(1.05)';
                    setTimeout(() => {
                        this.style.transform = 'scale(1)';
                    }, 300);
                });
            }
        });
    </script>
</body>
</html>