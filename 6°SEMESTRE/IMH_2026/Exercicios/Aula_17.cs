npm install -D tailwindcss postcss autoprefixer
npx tailwindcss init -p

_

export default {
  content: ["./index.html", "./src/**/*.{js,jsx}"],
  theme: {
    extend: {}
  },
  plugins: []
};

_

@tailwind base;
@tailwind components;
@tailwind utilities;

_

function Layout({ children }) {
  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-blue-600 text-white p-4">
        <h1 className="text-xl font-bold">Dashboard Corporativo</h1>
      </header>

      <main className="p-6">{children}</main>
    </div>
  );
}

export default Layout;

_

function MetricCard({ titulo, valor }) {
  return (
    <div className="bg-white p-4 rounded shadow">
      <p className="text-gray-500 text-sm">{titulo}</p>
      <p className="text-2xl font-bold">{valor}</p>
    </div>
  );
}

export default MetricCard;

_

import MetricCard from "../components/MetricCard";
import Layout from "../components/Layout";

function Dashboard() {
  return (
    <Layout>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        <MetricCard titulo="Produtos" valor="120" />
        <MetricCard titulo="Ativos" valor="95" />
        <MetricCard titulo="Faturamento" valor="R$ 120.000" />
      </div>
    </Layout>
  );
}

export default Dashboard;

_

npm install chart.js react-chartjs-2

_

import { Bar } from "react-chartjs-2";

function Chart() {
  const data = {
    labels: ["Jan", "Fev", "Mar"],
    datasets: [
      {
        label: "Vendas",
        data: [30, 45, 60],
        backgroundColor: "#2563eb"
      }
    ]
  };

  return (
    <div className="bg-white p-4 rounded shadow mt-6">
      <Bar data={data} />
    </div>
  );
}

export default Chart;

_

function Table({ dados }) {
  return (
    <div className="overflow-x-auto bg-white rounded shadow mt-6">
      <table className="min-w-full">
        <thead className="bg-gray-200">
          <tr>
            <th className="p-2 text-left">Nome</th>
            <th className="p-2 text-left">Preço</th>
            <th className="p-2 text-left">Status</th>
          </tr>
        </thead>
        <tbody>
          {dados.map((d, i) => (
            <tr key={i} className="border-b">
              <td className="p-2">{d.nome}</td>
              <td className="p-2">{d.preco}</td>
              <td className="p-2">
                <span className="text-green-600">Ativo</span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Table;

_

import Chart from "../components/Chart";
import Table from "../components/Table";

const dados = [
  { nome: "Notebook", preco: "R$ 4.500" },
  { nome: "Mouse", preco: "R$ 150" }
];

function Dashboard() {
  return (
    <Layout>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        <MetricCard titulo="Produtos" valor="120" />
        <MetricCard titulo="Ativos" valor="95" />
        <MetricCard titulo="Faturamento" valor="R$ 120.000" />
      </div>

      <Chart />
      <Table dados={dados} />
    </Layout>
  );
}



