using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Aula_04.Migrations
{
    /// <inheritdoc />
    public partial class initial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Categorias",
                columns: table => new
                {
                    Id = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    NomeCategoria = table.Column<string>(type: "nvarchar(max)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Categorias", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Fornecedores",
                columns: table => new
                {
                    Id = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Nome = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Documento = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Ativo = table.Column<bool>(type: "bit", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Fornecedores", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Produtos",
                columns: table => new
                {
                    Id = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    NomeProduto = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Preco = table.Column<decimal>(type: "decimal(18,2)", nullable: false),
                    Ativo = table.Column<bool>(type: "bit", nullable: false),
                    Fornecedor_Id = table.Column<string>(type: "nvarchar(450)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Produtos", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Produtos_Fornecedores_Fornecedor_Id",
                        column: x => x.Fornecedor_Id,
                        principalTable: "Fornecedores",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateTable(
                name: "CategoriaProdutos",
                columns: table => new
                {
                    Id = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Categoria_Id = table.Column<string>(type: "nvarchar(450)", nullable: false),
                    Produto_Id = table.Column<string>(type: "nvarchar(450)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CategoriaProdutos", x => x.Id);
                    table.ForeignKey(
                        name: "FK_CategoriaProdutos_Categorias_Categoria_Id",
                        column: x => x.Categoria_Id,
                        principalTable: "Categorias",
                        principalColumn: "Id");
                    table.ForeignKey(
                        name: "FK_CategoriaProdutos_Produtos_Produto_Id",
                        column: x => x.Produto_Id,
                        principalTable: "Produtos",
                        principalColumn: "Id");
                });

            migrationBuilder.CreateIndex(
                name: "IX_CategoriaProdutos_Categoria_Id",
                table: "CategoriaProdutos",
                column: "Categoria_Id");

            migrationBuilder.CreateIndex(
                name: "IX_CategoriaProdutos_Produto_Id",
                table: "CategoriaProdutos",
                column: "Produto_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Produtos_Fornecedor_Id",
                table: "Produtos",
                column: "Fornecedor_Id");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "CategoriaProdutos");

            migrationBuilder.DropTable(
                name: "Categorias");

            migrationBuilder.DropTable(
                name: "Produtos");

            migrationBuilder.DropTable(
                name: "Fornecedores");
        }
    }
}
