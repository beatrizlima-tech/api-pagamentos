package br.com.cotiinformatica.api_pagamentos.components;

import br.com.cotiinformatica.api_pagamentos.dtos.PedidoDTO;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.MimeMessageHelper;

@Component
public class EmailComponent {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarComprovantePagamento(PedidoDTO pedido) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(pedido.cliente().email());
            helper.setSubject("Comprovante de Pagamento - Pedido " + pedido.id());

            String html = """
                <html>
                <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
                    <div style="max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 10px;">
                        
                        <h2 style="color: #2c3e50;">💳 Comprovante de Pagamento</h2>
                        <p>Olá <strong>%s</strong>,</p>
                        <p>Seu pagamento foi realizado com sucesso. Confira os detalhes abaixo:</p>
                
                        <hr/>
                
                        <h3>📦 Dados do Pedido</h3>
                        <p><strong>ID do Pedido:</strong> %s</p>
                        <p><strong>Data:</strong> %s</p>
                        <p><strong>Valor Total:</strong> R$ %.2f</p>
                
                        <hr/>
                
                        <h3>🧾 Itens do Pedido</h3>
                        <table style="width:100%%; border-collapse: collapse;">
                            <thead>
                                <tr style="background-color: #2c3e50; color: white;">
                                    <th style="padding: 10px; border: 1px solid #ddd;">Produto</th>
                                    <th style="padding: 10px; border: 1px solid #ddd;">Preço</th>
                                    <th style="padding: 10px; border: 1px solid #ddd;">Quantidade</th>
                                    <th style="padding: 10px; border: 1px solid #ddd;">Subtotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                %s
                            </tbody>
                        </table>
                
                        <hr/>
                
                        <h3 style="color: #27ae60;">✅ Pagamento Confirmado</h3>
                        <p>Obrigado por comprar conosco!</p>
                
                    </div>
                </body>
                </html>
                """.formatted(
                    pedido.cliente().nome(),
                    pedido.id(),
                    pedido.dataHora(),
                    pedido.valor(),
                    gerarItensHtml(pedido)
            );

            helper.setText(html.toString(), true);

            javaMailSender.send(message);

            System.out.println("Email enviado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String gerarItensHtml(PedidoDTO pedido) {
        StringBuilder itens = new StringBuilder();

        pedido.itensPedido().forEach(item -> {
            double subtotal = item.produto().preco() * item.quantidade();

            itens.append("""
            <tr>
                <td style="padding: 8px; border: 1px solid #ddd;">%s</td>
                <td style="padding: 8px; border: 1px solid #ddd;">R$ %.2f</td>
                <td style="padding: 8px; border: 1px solid #ddd;">%d</td>
                <td style="padding: 8px; border: 1px solid #ddd;">R$ %.2f</td>
            </tr>
        """.formatted(
                    item.produto().nome(),
                    item.produto().preco(),
                    item.quantidade(),
                    subtotal
            ));
        });

        return itens.toString();
    }
}
